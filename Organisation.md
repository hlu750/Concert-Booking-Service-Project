Document some design choices and the organisation of your team:
Create a document named Organisation.md containing the following details:

Summary of what each team member did and how the team was organised. For example, the team may discuss the domain model together but only one person implements. This will mean we might only see commits from that person, and wonder if the other members were involved. A short explanation in Organisation.md will help this. It could be a couple of sentences for each member or a simple All members participated about the same for everything (in which case the logs should reflect this).

Short description of the strategy used to minimise the chance of concurrency errors in program execution (2-3 sentences)

Short description of how the domain model is organised (2-3 sentences)

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