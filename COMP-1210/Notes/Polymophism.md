# Polymorphism
Overview
#### - Define polymorphsim ans its benifits
#### - using inheritence to create polymorphic refrences
#### - using interfaces to create polymorphic refrences


## Polymorphism
```
	Occupation job;
```
- java allows the variable 'job' to refrence *Occupation* object or any other object of a **compatible type** 
- compatiablity can be established by **inheritence** or by using **interfaces**
- an object refrence can refer to an object of its class, **or to an object of any class**
- for example
```
	Person p = new patient("", "", "US", 1970);
	p = new ICUPatient("", "", 19, 1980);
	Staff s = new Doctor("", "", "Lab", "");
	p = s; // can we do this? 
```
- Assigning a child object to a parent reference is considered a *widening conversion*
- Assigning a parent reference to a child reference can be done also, but it is considered a narrowing assignment and must be done with a cast.
```
	Staff a = new Doctor("", "", "Lab", "");
	Doctor d = (doctor) s;
```
- widening conversion is the most useful

## Polymosphism via Inheritance

- when an object reference is declared as a parent type, you only have to access the methods in the parent class.
	- the methods specific to the child can only be accessed using casting
- fr example, you can not invoke s.setSpeciality() on the s object below even though setSpeciality is defined in Doctor.java. A cast is required since its unknown to Staff.
```
	Staff s = new Doctor("", "", "Lab", "");
	((Doctor)s).setSpeciality("Surgeon");
```
- the instanceof operator can be used to determine if an object is an instance of a class
```
	Doctor d  new Doctor("", "", "Lab", "");
	if (d instanceof Doctor) {
		System.out.println("d is a Doctor");
	}
	if (d isnatnce of Person) {
		System.out.println("d is a Person");
	}
```
> would print the following:
```
	d is a Doctor
	d is a Person
```
- when a method is invoked on object referenced by a superclass variable, the method must be present in the superclass, the version of the method associated with the subclass is the one that is actually invoked.
-for different version of getId() are invoked even though all objects in personArary are of type Person
```
	for (Person p : persoArray) {
		System.out.println(p.getId());
	}
```

### Binding
- consider the following method invocation:
```
	obj.toString();
```

- at some point, this invocation is *bound* to the definition of the method that it invokes
- if this binding occurred at compile time, then that line of code would call the same method every time
- however, Java defers method binding until run time -- this is called *dynamic binding* or *late binding*
- thus, in out PrintHospistal example, the appropriate getId() method was bound while the program was running.


## Polymophism via Interfaces

- an interface can be name be used as the type of object refrence variable 
```
	Comparable current;
```
-the *current* refrence can be used to point to any object of any class the implements the *Comparable* interface
- the version of *compareTo* that the following line invokes depends on the type of object that *current* is refrenceing
```
	current.comparetTo(cOBJ);
```

- all object refrences in Java are potentially polymorphic, because all classes inherit from the Object class and all interfaces have implicit abstract methods that match the public methods in the Object class unless these methods are explicitly declared
- the object class has the following methods (not all)
	- clone(), equals(), toString()
- thus any object reference , regardless of its declaration type can access the above methods

- the *instanceof* operator can be used to determine if an object is an instance of a class
















