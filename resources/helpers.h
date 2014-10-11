#pragma once

#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <string.h>
#include <string>
#include <sstream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

class Utils {
public:
	template<typename T>
	static string vectorToString(vector<T>& v);
	template<typename T>
	static string join(vector<T> v, string delimitor, function<string(T&)> transform, string prefix = "", string suffix = "");
};
template<typename T>
string Utils::vectorToString(vector<T>& v) {
	stringstream ss;
	ss << "[";
	for(T el : v) {
		ss << el.toString();
	}
	ss << "]";
	return ss.str();
}
template<typename T>
string Utils::join(vector<T> v, string delimitor, function<string(T&)> transform, string prefix, string suffix) {
	if(v.empty()) {
		return "";
	}
	string out = prefix + transform(v[0]);
	for(int i = 1; i < v.size(); i++) {
		out += delimitor + transform(v[i]);
	}
	out += suffix;
	return out;
}

class Modifier {
public:

	enum ModifierEnum { 
		PUBLIC, PROTECTED, PRIVATE, DEFAULT,
		ABSTRACT, FINAL, STATIC, SYNCHRONIZED
	};

	static map<ModifierEnum, string> modifierMap;
	static vector<Modifier> accessModifiers;

	static string getName(ModifierEnum type);
	static ModifierEnum getType(string name);
	ModifierEnum type;
	Modifier(ModifierEnum type);
	Modifier(string name);

	string toString();
	bool operator==(const Modifier& other);
};

class Variable {
public:
        string data_type;
        string name;
	string value;
        // modifiers: final, public, static etc.
        // bool isArgument() { return !isPublic() && !isStatic() ...; }
	Variable(string name, string data_type);
	Variable(string name, string data_type, string value);
	string toString();
};
        
class SubRoutine {
public:
        string name;
        vector<Variable> arguments;
	vector<Modifier> modifiers;

        SubRoutine(string name, vector<Variable> arguments, vector<Modifier> modifiers);
        SubRoutine(string name, vector<Variable> arguments);
        SubRoutine(string name);

        virtual string toString();  
};

class Method : public SubRoutine {
public:
        string return_type;

        Method(string name, string return_type, vector<Variable> arguments, vector<Modifier> modifiers);
        Method(string name, string return_type, vector<Variable> arguments);
        Method(string name, string return_type);

        virtual string toString();  
};

class Constructor : public SubRoutine {
public:
        Constructor(string name, vector<Variable> arguments, vector<Modifier> modifiers);
        Constructor(string name, vector<Variable> arguments);
        Constructor(string name);
};

class Class {
public:
	string name;
	vector<Variable> members;
	vector<Constructor> constructors;
	vector<Method> methods;
	
	Class(string name, vector<Variable> members, vector<Method> methods);
	Class(vector<Variable> members, vector<Method> methods);
	Class() = default;
	
	string toString();
};

