# Software Design Diagrams

Designing a software application involves creating several types of diagrams to represent different aspects of the system. These diagrams are categorized into **High-Level Design (HLD)** and **Low-Level Design (LLD)** diagrams.

---

## **High-Level Design (HLD) Diagrams**
HLD provides an abstract view of the system, focusing on architecture, modules, and external interfaces.

### 1. **Architecture Diagram**
- Shows the overall system structure and how various components interact.
- Example: Client-server architecture, microservices, or layered architecture.

### 2. **Data Flow Diagram (DFD)**
- Illustrates how data moves through the system.
- Levels:
  - **Level 0**: Context diagram showing the system and external entities.
  - **Level 1/2**: Breaks down processes and data flows in detail.

### 3. **Component Diagram**
- Describes the major components/modules of the system and their interactions.
- Useful for understanding deployment and modular design.

### 4. **Network Diagram**
- Represents the physical or virtual network setup for the application.
- Includes servers, firewalls, databases, and cloud services.

### 5. **Entity-Relationship Diagram (ERD)**
- Visualizes database structure by showing entities (tables) and relationships.
- Useful for designing the data model.

### 6. **Use Case Diagram**
- Highlights user interactions with the system.
- Depicts actors (users or systems) and the actions they can perform.

---

## **Low-Level Design (LLD) Diagrams**
LLD provides detailed insights into the implementation of the system's modules and functionalities.

### 1. **Class Diagram**
- Represents classes, their attributes, methods, and relationships (inheritance, association, etc.).
- Important for Object-Oriented Design (OOD).

### 2. **Sequence Diagram**
- Details the sequence of interactions between objects or components over time.
- Useful for understanding workflows and real-time interactions.

### 3. **Activity Diagram**
- Depicts workflows or business processes as a series of activities.
- Useful for logic-heavy processes or user flows.

### 4. **State Diagram**
- Shows the states of an object and transitions triggered by events.
- Useful for designing finite state machines or dynamic behaviors.

### 5. **Deployment Diagram**
- Represents the physical deployment of software components on hardware.
- Includes servers, nodes, and middleware.

### 6. **Flowchart**
- Describes the logic of a specific functionality or algorithm.
- Useful for explaining control flow and conditions.

### 7. **Detailed Data Models**
- Elaborates the database schema with indexes, constraints, and relationships.
- Includes mapping between logical and physical models.

---

## **Choosing Diagrams**

### **Early Stages**
- Focus on HLD diagrams like architecture, DFDs, and use case diagrams.

### **Detailed Design**
- Include LLD diagrams like class diagrams, sequence diagrams, and deployment diagrams.

### **Documentation**
- Ensure diagrams are included in the design document for reference and clarity.

---
