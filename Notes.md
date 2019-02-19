## **Setup**
https://stackoverflow.com/questions/15508967/change-root-context-for-a-servlet-in-an-intellij-idea-project/15511476#15511476

https://www.youtube.com/watch?time_continue=73&v=kDNihsx8j8k

## IoC
> Design process of externalizing, the construction and management of your objects
> You app will outsource the creation and management of the objects, and that outsourcing will be handled by a object factory

## Spring Container
> Primary functions:
>* Create and manage objects (IoC)
>* Inject object's dependencies (DI)

## Configuring 
> XML config
> Java Annotations
> Java Source Code


## Spring dev process
> Configure your Spring Beans

> Create a spring container
>* Spring container is generically known as **Application Context**
>* Specialised implementations
>* 1. ClassPathXmlApplicationContext
>* 2. AnnotationConfigApplicationContext
>* 3. GenericWebApplicationContext
>* others
> Retrieve beans from spring container




## **Spring Bean**
> A "Spring Bean" is simply a Java object.
> When Java objects are created by the Spring Container, then Spring refers to them as "Spring Beans".
> Spring Beans are created from normal Java classes .... just like Java objects.
> In summary, whenever you see "Spring Bean", just think Java object. 



> Why do we specify the Coach interface in getBean()?
> When we pass the interface to the method, behind the scenes Spring will cast the object for you.
> However, there are some slight differences than normal casting.
> From the Spring docs:
> Behaves the same as getBean(String), but provides a measure of type safety by throwing a BeanNotOfRequiredTypeException if the bean is not of the required type. This means that ClassCastException can't be thrown on casting the result correctly, as can happen with getBean(String).


## **Dependency Injection**
> The client delegates to calls to another object the responsibility of providing its dependencies.

> Question:
> I was wondering why you created a no arg constructor? I thought that they are implied by Java and only required when you also have an overloaded constructor. Or is this a Spring specific thing?

> Answered by: 
> When you don’t define any constructor in your class, compiler defines default one for you, however when you declare any constructor (in your example you have already defined a parameterized constructor), compiler doesn’t do it for you.

> Since you have defined a constructor in class code, compiler didn’t create default one. While creating object you are invoking default one, which doesn’t exist in class code. Then the code gives an compilation error.

## **Generic Setup**
``` java
// Generic interface
Interface myInterface = context.getBean("linkName", Interface.class);
myInterface.doSomething();

// For explicit implementation - usually to access the additional methods in the implemented interface
ImplementationInterface myInterface = context.getBean("linkName", ImplementationInterface.class);
myInterface.doSomething2();
```
``` xml
<bean id="linkName" class="location.of.implementationInterface">
```



## **Bean scope**
> Default bean is singleton 
>* Spring Container creates only one instance of the bean, by default 
>* It is cached in memory 
>* All requests for the bean
>* will return a SHARED reference to the SAME bean

> Prototype scope: new object for each request


## **Bean Life Cycle**
______
Special Note about init and destroy Method Signatures

When using XML configuration, I want to provide additional details regarding the method signatures of the init-method  and destroy-method .

Access modifier
The method can have any access modifier (public, protected, private)

Return type
The method can have any return type. However, "void' is most commonly used. If you give a return type just note that you will not be able to capture the return value. As a result, "void" is commonly used.

Method name
The method can have any method name.

Arguments
The method can not accept any arguments. The method should be no-arg.
______

There is a subtle point you need to be aware of with "prototype" scoped beans.

For "prototype" scoped beans, Spring does not call the destroy method.  Gasp!  

In contrast to the other scopes, Spring does not manage the complete lifecycle of a prototype bean: the container instantiates, configures, and otherwise assembles a prototype object, and hands it to the client, with no further record of that prototype instance.

Thus, although initialization lifecycle callback methods are called on all objects regardless of scope, in the case of prototypes, configured destruction lifecycle callbacks are not called. The client code must clean up prototype-scoped objects and release expensive resources that the prototype bean(s) are holding. 

This also applies to both XML configuration and Annotation-based configuration.
___

> for singleton beans - both init-method and destroy-method are called
> for prototype beans - only init-method is called


## **Java Annotations**
> At compiler time, compiler will check/verify

> Spring will scan your Java classes for special annotations
> Automatically register the beans in the Spring container
@Component("TennisCoach")

@Component
> Spring also supports Default Bean IDs
>* Default bean id: the class name, make first letter lower-case

> For DI, Spring can use auto wiring
> Spring will look for a class that matches the property
>* matches by type: class or interface
> Spring will inject it automatically.. hence it is autowired

___
AUTOWIRING
FAQ: What if there are multiple FortuneService implementations?
When using autowiring, what if there are multiple FortuneService implementations? 

ANSWER
Spring has special support to handle this case. Use the @Qualifier annotation. We'll cover this later in the course with slides and code examples. But don't worry, we will address all scenarios :-)

___
Question
I have finished the video "Constructor Injection - Writing Code part2". 
I have commented the Autowired annotation. But still it worked. How did it work?

Answer
> This is a new feature of Spring 4.3.
> Here is the snippet from the Spring Docs.

Section 1.9.2: Autowired
> As of Spring Framework 4.3, an @Autowired annotation on such a constructor is no longer necessary if the target bean only defines one constructor to begin with. However, if several constructors are available, at least one must be annotated to teach the container which one to use.
> I personally prefer to use the @Autowired annotation because it makes the code more readable. But as mentioned, the @Autowired is not required for this scenario.
___

**Field injection**
> Just put @Autowired on field - not need for setter methods
> Need default constructor

**Which one to use**
> Choose style and stay consistent

___

Multiple interface implementations - use @Qualfier("beanID")
> Used on all types of injection


___

Annotations - Default Bean Names ... and the Special Case

In general, when using Annotations, for the default bean name, Spring uses the following rule.

If the annotation's value doesn't indicate a bean name, an appropriate name will be built based on the short name of the class (with the first letter lower-cased).

For example:

HappyFortuneService --> happyFortuneService

---

However, for the special case of when BOTH the first and second characters of the class name are upper case, then the name is NOT converted.

For the case of RESTFortuneService

RESTFortuneService --> RESTFortuneService

No conversion since the first two characters are upper case.

Behind the scenes, Spring uses the Java Beans Introspector to generate the default bean name. Here's a screenshot of the documentation for the key method.

___

## **Using @Qualifier with Constructors**

@Qualifier is a nice feature, but it is tricky when used with Constructors.

The syntax is much different from other examples and not exactly intuitive.  Consider this the "deep end of the pool" when it comes to Spring configuration LOL :-)

 You have to place the @Qualifier annotation inside of the constructor arguments. 

Here's an example from our classroom example. I updated it to make use of constructor injection, with @Autowired and @Qualifier. Make note of the code in bold below:

---
package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    // define a default constructor
    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }
    
    @Autowired
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {

        System.out.println(">> TennisCoach: inside constructor using @autowired and @qualifier");
        
        fortuneService = theFortuneService;
    }
        
    
    /*
    @Autowired
    public void doSomeCrazyStuff(FortuneService theFortuneService) {
        System.out.println(">> TennisCoach: inside doSomeCrazyStuff() method");
        fortuneService = theFortuneService;
    }
    */
    
    /*
    @Autowired
    public TennisCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }
    */
    
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}

---


FAQ: How to inject properties file using Java annotations
Section 8, Lecture 74

Answer:

This solution will show you how inject values from a properties file using annotatons. The values will no longer be hard coded in the Java code.

1. Create a properties file to hold your properties. It will be a name value pair.  

New text file:  src/sport.properties

foo.email=myeasycoach@luv2code.com
foo.team=Silly Java Coders
Note the location of the properties file is very important. It must be stored in src/sport.properties

2. Load the properties file in the XML config file.

File: applicationContext.xml

Add the following lines:

    <context:property-placeholder location="classpath:sport.properties"/>  

This should appear just after the <context:component-scan .../> line

3. Inject the properties values into your Swim Coach: SwimCoach.java

   

@Value("${foo.email}")
private String email;
    
@Value("${foo.team}")
private String team;
__

Special Note about @PostConstruct and @PreDestroy Method Signatures

I want to provide additional details regarding the method signatures of @PostContruct and @PreDestroy methods.

Access modifier

The method can have any access modifier (public, protected, private)

Return type
The method can have any return type. However, "void' is most commonly used. If you give a return type just note that you will not be able to capture the return value. As a result, "void" is commonly used.

Method name
The method can have any method name.

Arguments
The method can not accept any arguments. The method should be no-arg.
___

Section 9, Lecture 80
HEADS UP - FOR JAVA 9, 10 and 11 USERS - @PostConstruct and @PreDestroy 

If you are using Java 9, 10 or 11, then you will encounter an error when using @PostConstruct and @PreDestroy in your code.

These are the steps to resolve it. Come back to the lecture if you hit the error. 

Error

Eclipse is unable to import @PostConstruct or @PreDestroy

This happens because of Java 9 and higher. 

When using Java 9 and higher, javax.annotation has been removed from its default classpath. That's why we Eclipse can't find it.

---

Solution

1. Download the javax.annotation-api-1.2.jar from 

http://central.maven.org/maven2/javax/annotation/javax.annotation-api/1.2/javax.annotation-api-1.2.jar

2. Copy the JAR file to the lib folder of your project

---

Use the following steps to add it to your Java Build Path.

3. Right-click your project, select Properties

4. On left-hand side, click Java Build Path

5. In top-center of dialog, click Libraries

6. Click Classpath and then Click Add JARs ...

7. Navigate to the JAR file <your-project>/lib/javax.annotation-api-1.2.jar

8. Click OK then click Apply and Close

Eclipse will perform a rebuild of your project and it will resolve the related build errors.
___

