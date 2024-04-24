# What is Java-Doc?
- Documentation generator from Sun Microsystem.
- Generates API documentation in HTML format from Java source code.
- The "doc comments" format is industry standard.
- The HTML format is used for adding the convenience of being able to hyperlink related document together.

#### Def: 
- Javadoc is an extensible documentation generation system which reads specially formatted comments in java source code and generates compiled documentation. It is typically used to produce API documentation in the form of HTML web pages.

# Why Use Java-Doc?
- Minimizes effort of creating a documentation.
- Makes it easier to keep the documentation up-to-date.
- Make using third-party classes(incl. Java API easier because everything is documented in the same way)
- Allows you to hyperlink related documents together.
- Consistent look and feel.
**Summary** 
- Java-Doc is used to help programmers and users understand code. It can also help with collaboration and knowledge sharing as clear comments within code can help team members quickly understand each other's code.
- It generates API documentation. It parses the declarations and documentation in a set of source file describing classes, methods, constructors and fields.

# Where should you used?
- Yes
	- Above  a class
	- Above a method
- No
	- Inside a method
- Not necessary
	- In a class that implements an interface assuming the interface has proper Java-Doc and that Java-Doc also describes the class.

# Format : 
- HTML : `<p>, <a href>, <code>, <ul>, <li>`
- Several special tags.
- First sentence should be a summary of the method/class. Distinguish the method from other methods.
- So character max-line length.
- Phrases, third person tone : OK
- Multi-line comment format.
```
/**
*
*
*/
```


# Tags : 
| Tag Name  | Purpose  | Location | Description | Parameter|
| --- | --- | --- | --- | --- |
| @author | Who wrote it or author name| Classes and interfaces |  Describes an author  | author-name |
| @param  | Implicit parameters, in the order that parameters are defined | Methods and constructor| provide information about method parameter  | Description |
| @return | Return value | Methods only|
| @exception |  |  |  |
| @see  |  |  |  | Reference|
| @since   |  |  | generate a link to other element of the document  |
| @serial  |  |  | |
| @deprecated  |  | |  |
| @version | |  | provide version of the class, interface or enum | version-name |
| @return  | |  | provide the return value  | description |
