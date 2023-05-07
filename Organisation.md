<!-- Document some design choices and the organisation of your team:
Create a document named Organisation.md containing the following details: -->

### list of members in our team
Name: Helen Lu 
UPI: hlu750 
GitHub identifier: hlu750 

Name: Rukun Aaron 
UPI: raar518 
GitHub identifier: Rukun-Aaron 

Name: Jae Ha 
UPI: jha286 
GitHub identifier: JaeHa457 

<!-- Summary of what each team member did and how the team was organised. For example, the team may discuss the domain model together but only one person implements. This will mean we might only see commits from that person, and wonder if the other members were involved. A short explanation in Organisation.md will help this. It could be a couple of sentences for each member or a simple All members participated about the same for everything (in which case the logs should reflect this). -->

### Organisation of the team
For this project, the team was organised as follows:
- All team members participated in group discussions about how to address the domain modelling and RESTful web service implementation. All team members contributed equally in the assignment.
- hlu750 implemented the domain modelling with raar518's help.
- raar518 implemented the RESTful web service with jha286 and hlu750's help.
- jha286 wrote the documentation and design choices.
- All team members reviewed the domain model, RESTful web service, and documentation.

Our team decided on what tasks we each wanted to start on at the start of the project (Rukun starting on Task 1, Jaeha starting on Task 2, Helen starting on documentation). Then over time we implemented the required tasks individually at first, but we eventually ended up focusing on different tasks and started helping out wherever help was needed as well as kept in contact with each other so that everyone had an idea of what stage the project was at. Helen Lu and Jae Ha started on Task 1 while Rukun Aaron started on Task 2. Rukun eventually fixed some changes and assisted on Task 1 while Helen Lu and Jae Ha helped Rukun Aaron on Task 2. Then Jae Ha worked on documenting the process with Helen's help while Rukun fixed some errors. 
Note: Jae ha's initial commit logs are in the Task 2 branch which the team didn't merge into the final branch and Helen committed the Organisation file on behalf of Jae and Helen.

### Concurrency
<!-- Short description of the strategy used to minimise the chance of concurrency errors in program execution (2-3 sentences) -->
To minimise the chance of concurrency errors in the programs execution, we used optimistic locking strategies. Optimistic Locking allows multiple users to access and modify the same data at the same time, which can ultimately improve performance and scalability. We believe optimistic locking would be the superior way to reduce concurrency errors as it is more flexible, as it will not require locking data for long periods of time (like pessimistic locking).

<!-- Short description of how the domain model is organised (2-3 sentences) -->
### Domain model organisation
The domain model is organised around the following entities and are related to each other as follows:
- Concert: represents a musical performance of one or more performers that takes place on one or more dates.
- Performer: represents a musician or group who performs at one or more concerts.
- User: represents a user of a theater.
- Seat: represents a seat at the concert, with a specific date and price.
- Booking: represents a booking for one or more seats at a specific concert date booked by a user.

<!-- Points to consider -->
<!-- To check your understanding of the various concepts used in this project, you should consider the following: -->

### Scalability
<!-- How have you made an effort to improve the scalability of your web service? -->
To improve the scalability of our web service, we have focused on the five key concepts: caching, statelessness, data design, asynchronous messages, and optimistic concurrency control. These measures guarantee that our web service can accommodate increased demand without crashing, which is crucial given how rapidly web services can gain popularity. We have implemented a distributed architecture, or a microservices architecture, that enables us to scale each service independently. We have employed caching mechanisms to reduce the number of database requests and utilized load balancing techniques to distribute the workload across multiple servers, allowing us to add resources as needed and overcome performance limitations. We have adhered to REST principles, including statelessness and caching, to ensure our server is horizontally scalable. By leveraging statelessness to authenticate users via session IDs stored in cookies and caching server responses in the client, we have optimized our web service's scalability.

### Lazy loading and eager fetching
<!-- What (implicit and explicit) uses of lazy loading and eager fetching are used within your web service. Why those uses are appropriate in the context of this web service? -->
In our web service, we have implemented both lazy loading and eager fetching to optimize database queries. Lazy loading is used for collections that may contain a large number of entities, such as reservations for a concert. This approach delays the initialization of objects until they are needed, which can improve startup and overall performance. For example, in the Booking class, explicit lazy loading is used for the User data, which is only loaded and initialized when an explicit call is made to it. This is appropriate for our web service as users may browse various concerts and dates without necessarily booking any shows yet.

On the other hand, eager fetching is used for entities that are frequently accessed, such as concerts or performers. This approach fetches collections fully at the same time as the parent, which reduces the time required to load data. For instance, the Concert class has dates which fetches all the dates simultaneously with the Concert. Eager loading is used here because it allows the users to see the concert dates and make a decision promptly so they don't miss out. 

These uses of lazy loading and eager fetching are appropriate for our web service as they minimize the number of queries to the database, hence improving performance and user experience.

### Concurrency
<!-- How have you made an effort to remove the possibility of issues arising from concurrent access, such as double-bookings? -->
To ensure that issues arising from concurrent access, such as double-bookings, are removed, our web service uses optimistic locking and transactions in our ConcertResource service when making a booking to ensure that only one client can book a given seat for a given concert on a given date. This method allows the client to make local changes to a resource, and when an update request is attempted, the client is notified if those changes are rejected by the server. We add the current version or last modification timestamp attribute to the resource to implement this method. By using optimistic concurrency, the system only throws an error when the same seat is being accessed.

<!-- How would you extend your web service to add support for the following new features?: -->

<!-- Support for different ticket prices per concert (currently ticket prices are identical for each concert) -->
To support different ticket prices per concert, we can add a PriceBand entity with a many-to-many relationship to Concert. Each PriceBand would have a name and a price, and a Concert could have multiple PriceBands associated with it. When a client makes a reservation, they would select which PriceBand(s) they want to book seats for, and the total cost would be calculated based on the selected PriceBands.

<!-- Support for multiple venues (currently all concerts are assumed to be at the same venue with an identical seat layout) -->
To support multiple venues, we can add a new entity for venues and associate it with the concert entity. We can also modify the reservation process to take into account the different seat layouts for each venue.

To support multiple venues, we can add a Venue entity with a one-to-many relationship to Concert. Each Venue would have a name and a layout that specifies the number and arrangement of seats. There could also potentially be more attributes. When a user wants to book seats for a Concert at a venue, the seating would be determined based on the Venue layout.

<!-- Support for "held" seats (where, after a user selects their seats, they are reserved for a period of time to allow the user time to pay. If the user cancels payment, or the time period elapses, the seats are automatically released, able to be booked again by other users). -->
To support held seats, we can introduce a new status for seats, "held". When a user selects seats, the seats would be marked as "held" for a specified period of time. If the user cancels the payment or the period of time elapses, the seats will automatically be made available again for other users to book. If the user pays within the hold period, the seat would be booked.

<!-- Important Note: Recording the above information as well as your overall project development experience will help in completing the Assignment 1 tasks too. Assignment 1 will be released in the second half of the course. --> --> -->