# George Backend Chapter - Coding Challenge
Congratulations. You made it to our next recruiting stage which is a coding challenge. In this stage you have to show practical skills in the things which you discussed in the previous recruiting stage:
- Object-Oriented Programming
- Refactoring
- Automated Testing (Developer Tests)

This stage contains one part
-  Remote-Pair-Programming Sessions (4 hours)

__Please note__: The home assignment is the precondition for the Remote-Pair-Programming Sessions. Only if we are happy with part 1 you will be invited to part 2 of our coding challenge stage. 

### Remote-Pair-Programming Sessions
You will collaborate in four sessions with George Backend Chapter team members in a remote fashion by using Skype. You will receive more details about the Remote-Pair-Programming sessions via email.

### Exercise: Gilded Rose Kata
Please find the requirements for the Gilded Rose Kata on the following [website](https://kata-log.rocks/gilded-rose-kata).

#### Introduction
Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a prominent city ran by a friendly innkeeper named Allison. We also buy and sell only the finest goods. Unfortunately, our goods are constantly degrading in quality as they approach their sell by date. We have a system in place that updates our inventory for us. It was developed by a no-nonsense type named Leeroy, who has moved on to new adventures. Your task is to add the new feature to our system so that we can begin selling a new category of items. First an introduction to our system:

- All items have a SellIn value which denotes the number of days we have to sell the item
- All items have a Quality value which denotes how valuable the item is
- At the end of each day our system lowers both values for every item

Pretty simple, right? Well this is where it gets interesting:

- Once the sell by date has passed, Quality degrades twice as fast
- The Quality of an item is never negative
- “Aged Brie” actually increases in Quality the older it gets
- The Quality of an item is never more than 50
- “Sulfuras”, being a legendary item, never has to be sold or decreases in Quality
- “Backstage passes”, like aged brie, increases in Quality as its SellIn value approaches;
- Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
- Quality drops to 0 after the concert

#### Your Task
We have recently signed a supplier of conjured items. This requires an update to our system:
- “Conjured” items degrade in Quality twice as fast as normal items

#### Rules
Feel free to make any changes to the UpdateQuality method and add any new code as long as everything still works correctly. However, do not alter the Item class or Items property as those belong to the goblin in the corner who will insta-rage and one-shot you as he doesn’t believe in shared code ownership (you can make the UpdateQuality method and Items property static if you like, we’ll cover for you).

Just for clarification, an item can never have its Quality increase above 50, however “Sulfuras” is a legendary item and as such its Quality is 80 and it never alters.

(Taken from the [github repo](https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/main/GildedRoseRequirements.txt))

### Focus
Please focus on code quality by applying
- Object-Oriented Design, 
- Refactoring and 
- Developer-Tests (aka Unit- and Integration-Tests).

### Feature Branches
In the George Backend Chapter you have to work in feature branches for each task. As soon as you finish your task you will open up a pull request on GitHub which then will be reviewed at least by two of your colleagues. Therefore, think of solving an iteration as if you would solve a task for our team. Always focus on quality and come up with a codebase which you would be happy working in. Empathy in our team is highly valued. We always put ourselves into our reviewers position to improve their life reviewing our code.

For each session, please create a branch with the following pattern: `firstname_lastname_name`. Your first session must branch off `main`, or in case you want to use Kotlin, please branch of `kotlin_maven_baseline`. Your branches won't be merged back to main. Every new branch must branch of the previous branch.

For the Remote-Pair-Programming Sessions please use the first name as a postfix of the team member who is going to work with you.

### Assumptions 
In case the requirements are ambiguous, please write down your assumptions into the project's `assumptions.txt` file. Please always create a section for each iteration and put your assumptions under this section. The reason for this is, so that we can follow certain design decisions in your code which you came up with based on your assumptions.

### Evaluation
This example might seem a bit hypothetical, but we believe it small but complicated enough, that it makes sense to come up with an Object-Oriented Design which is more than implementing your whole solution in a single main method 😉. The evaluation won't take longer than 3 work days. If we are happy with your solution we will send you the information for the next steps of our recruiting process which will be done by someone from our HR-department. In case we won't continue the recruiting process with you, we will send you a detailed feedback of our evaluation.

### Requirements
Please use Java 8 or Kotlin as a programming language. No Framework is allowed for this exercise. No other library than JUnit must be used. Currently JUnit 5 is configured in the `pom.xml`. In case you prefer JUnit 4 over 5 please change the `pom.xml` file accordingly. We don’t allow any mocking library. In case you see the need for mocking, please hand roll your mocks.

### Questions
In case this description triggers some questions on your side, please don’t hesitate to get in touch with us. Other than that, we recommend starting with this exercise as soon as possible after you have received it. We wish you good luck and are very much looking forward to your solution.

