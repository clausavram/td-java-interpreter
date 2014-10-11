#include "helpers.h"
#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <string.h>
#include <string>
#include <sstream>
#include <vector>
#include <algorithm>
#include <map>
#include <exception>
using namespace std;

Variable::Variable(string name, string data_type, string value) : name(name), data_type(data_type), value(value) { }
Variable::Variable(string name, string data_type) : Variable(name, data_type, "") { }
string Variable::toString() {
	stringstream ss;
	ss << name << ":" << data_type;
	if(value.length() > 0) {
		ss << "='" << value << "'";
	}
	return ss.str();
}


SubRoutine::SubRoutine(string name, vector<Variable> arguments, vector<Modifier> modifiers) : name(name), arguments(arguments), modifiers(modifiers) { 
	bool foundAccessModifier = false;
	vector<Modifier> inputAccessModifiers;
	for(auto it = this->modifiers.begin(); it != this->modifiers.end(); ++it) {
		if(find(Modifier::accessModifiers.begin(), Modifier::accessModifiers.end(), *it) != Modifier::accessModifiers.end()) {
			inputAccessModifiers.push_back(*it);
			foundAccessModifier = true;
		}
	}
	if(foundAccessModifier) {
		if(inputAccessModifiers.size() > 1) {
			cout << "WARNING: Found more than one access modifier for method " << name << ": " 
			     << Utils::join<Modifier>(inputAccessModifiers, ", ", [](Modifier& m) { return m.toString(); }, "<", ">") << endl;
		}
	}
}
SubRoutine::SubRoutine(string name, vector<Variable> arguments) : SubRoutine(name, arguments, vector<Modifier>()) { }
SubRoutine::SubRoutine(string name) : SubRoutine(name, vector<Variable>(), vector<Modifier>()) { }
string SubRoutine::toString() {
	string args = Utils::join<Variable>(arguments, ", ", [](Variable& v) { return v.toString();});
	string modifs; 
	if(!modifiers.empty()) {
		modifs = Utils::join<Modifier>(modifiers, ", ", [](Modifier& m) { return m.toString(); }, "|", "");
	} else {
		modifs = "";
	}
	ostringstream out;
	out << name << '(' << args << ")" << modifs;
	return out.str();
}  
        
Method::Method(string name, string return_type, vector<Variable> arguments, vector<Modifier> modifiers) : SubRoutine(name, arguments, modifiers) { 
	this->return_type = return_type; 
}
Method::Method(string name, string return_type, vector<Variable> arguments) : Method(name, return_type, arguments, vector<Modifier>()) { }
Method::Method(string name, string return_type) : Method(name, return_type, vector<Variable>()) { }
string Method::toString() {
	string args = Utils::join<Variable>(arguments, ", ", [](Variable& v) { return v.toString();});
	string modifs; 
	if(!modifiers.empty()) {
		modifs = Utils::join<Modifier>(modifiers, ", ", [](Modifier& m) { return m.toString(); }, " | ", "");
	} else {
		modifs = "";
	}
	ostringstream out;
	out << name << '(' << args << "):" << return_type << modifs;
	return out.str();
}

Constructor::Constructor(string name, vector<Variable> arguments, vector<Modifier> modifiers) : SubRoutine(name, arguments, modifiers) { }
Constructor::Constructor(string name, vector<Variable> arguments) : Constructor(name, arguments, vector<Modifier>()) { }
Constructor::Constructor(string name) : Constructor(name, vector<Variable>(), vector<Modifier>()) { }

Class::Class(string name, vector<Variable> members, vector<Method> methods) : name(name), members(members), methods(methods) { }
Class::Class(vector<Variable> members, vector<Method> methods) : Class("N/A", members, methods) { }
string Class::toString() {
	stringstream ctors;
	if(!constructors.empty()) {
		ctors << " Constructors: " << Utils::join<Constructor>(constructors, ", ", [](Constructor& ctor) { return ctor.toString(); }, "<", ">");
	}
	stringstream meths;
	if(!methods.empty()) {
		meths << " Methods: " << Utils::join<Method>(methods, ", ", [](Method& m) { return m.toString(); }, "<", ">");
	}

	stringstream out;
	out << "\'" << name << "': {Fields: " 
		<< Utils::join<Variable>(members, ", ", [](Variable& v) { return v.toString(); }, "<", ">")
		<< ctors.str()
		<< meths.str()
		<< "}";
	return out.str();
}

vector<Modifier> Modifier::accessModifiers = vector<Modifier>({ 
	Modifier(Modifier::ModifierEnum::PUBLIC),
	Modifier(Modifier::ModifierEnum::PROTECTED),
	Modifier(Modifier::ModifierEnum::PRIVATE)
});

map<Modifier::ModifierEnum, string> Modifier::modifierMap = map<Modifier::ModifierEnum, string>{
	pair<Modifier::ModifierEnum, string>(Modifier::ModifierEnum::PUBLIC, "public"),
	pair<Modifier::ModifierEnum, string>(Modifier::ModifierEnum::PRIVATE, "private"),
	pair<Modifier::ModifierEnum, string>(Modifier::ModifierEnum::PROTECTED, "protected"),
	pair<Modifier::ModifierEnum, string>(Modifier::ModifierEnum::STATIC, "static"),
	pair<Modifier::ModifierEnum, string>(Modifier::ModifierEnum::FINAL, "final"),
	pair<Modifier::ModifierEnum, string>(Modifier::ModifierEnum::SYNCHRONIZED, "synchronized"),
	pair<Modifier::ModifierEnum, string>(Modifier::ModifierEnum::ABSTRACT, "abstract"),
};
string Modifier::getName(Modifier::ModifierEnum type) {
	return modifierMap[type];
}
Modifier::ModifierEnum Modifier::getType(string name) {
	for(auto it = modifierMap.begin(); it != modifierMap.end(); ++it) {
		if(it->second == name) {
			return it->first;
		}
	}
	stringstream message;
	cout << "ERROR: Modifier name not found: " << name << endl;
	return ModifierEnum::PUBLIC;
}
Modifier::Modifier(Modifier::ModifierEnum type) : type(type) { }
Modifier::Modifier(string name) : type(getType(name)) { }
string Modifier::toString() {
	return Modifier::getName(type);	
}
bool Modifier::operator==(const Modifier& other) {
	return this->type == other.type;	
}
