Document some design choices and the organisation of your team: 
Create a document named Organisation.md containing the following details:

Summary of what each team member did and how the team was organised. For example, the team may discuss the domain model together but only one person implements. This will mean we might only see commits from that person, and wonder if the other members were involved. A short explanation in Organisation.md will help this. It could be a couple of sentences for each member or a simple All members participated about the same for everything (in which case the logs should reflect this).

***
Our team decided on what tasks we each wanted to start on at the start of the project. Then over time we implemented the required tasks individually at first, but we eventually started helping out wherever help was needed as well as kept in contact with each other so that everyone had an idea of what stage the project was at. Helen Lu and Jae Ha started on Task 1 while Rukun Aaron started on Task 2. Rukun eventually fixed some changes and assisted on Task 1 while Helen Lu helped Rukun Aaron on Task 2. 
***

Short description of the strategy used to minimise the chance of concurrency errors in program execution (2-3 sentences)

***
To minimise the chance of concurrency errors in the programs execution, we used optimistic locking strategies. Optimistic Locking allows multiple users to access and modify the same data at the same time, which can ultimately improve performance and scalability. We believe optimistic locking would be the superior way to reduce concurrency errors as it is more flexible, as it will not require locking data for long periods of time (like pessimistic locking).
***

Short description of how the domain model is organised (2-3 sentences)

***
We used Lazy loading for the Booking.java and Performer.java files, while Eager loading was used for Concert.Java.
***

Points to consider
To check your understanding of the various concepts used in this project, you should consider the following:

How have you made an effort to improve the scalability of your web service?

What (implicit and explicit) uses of lazy loading and eager fetching are used within your web service. Why those uses are appropriate in the context of this web service?

How have you made an effort to remove the possibility of issues arising from concurrent access, such as double-bookings?

How would you extend your web service to add support for the following new features?:

Support for different ticket prices per concert (currently ticket prices are identical for each concert)

Support for multiple venues (currently all concerts are assumed to be at the same venue with an identical seat layout)

Support for "held" seats (where, after a user selects their seats, they are reserved for a period of time to allow the user time to pay. If the user cancels payment, or the time period elapses, the seats are automatically released, able to be booked again by other users).

Important Note: Recording the above information as well as your overall project development experience will help in completing the Assignment 1 tasks too. Assignment 1 will be released in the second half of the course.