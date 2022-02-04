<div id="top"></div>




<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->




<!-- PROJECT LOGO -->




<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#Why-are-we-doing-this">Why are we doing this?</a>
        <li><a href="#built-with">Built With</a></li>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>    
        <li><a href="#what-went-well">What went well</a></li>
        <li><a href="#what-went-wrong">What went wrong</a></li>
    </li>
    <li><a href="#Possible-improvements-for-future-revisions">Possible improvements for future revisions</a></li>
    <li><a href="#Postman-/-API-Screenshots">Postman / API Screenshots</a></li>
    <li><a href="#Database-screenshots-to-show-Data-is-being-persistence">Database screenshots to show Data is being Persisted</a></li>
    <li><a href="#Link-to-my-jira-board">Link to my Jira board</a></li>

  </ol>
</details>


<!-- ABOUT THE PROJECT -->
## Why are we doing this 

During the DfE Software Pathway with QA, we covered Java, SpringBoot and MySQL amongst other things, and to finish off all of this learning we were tasked with creating a fully functioning API, with CRUD functionality, fully designed test suites and documentation. 
I decided to create a Recipe storage system, using JPA for the repository, H2 for the on-memory database for development and testing and then persisted the data in MySQL, and used Postman to send requests to my API to check functionality. 

<details>
<summary>The MVP targets for this project were</summary>
<ul> 
  <li>Code fully integrated into a Version Control System using the feature-branch model: **main/dev/multiple features**</li>
  <li>A project management board with full expansion on user stories, accpetance criteria and tasks needed to complete the project</li>
  <li>A risk assessment which outlines the issues and risks faced during the project timeframe</li>
  <li>A relational database, locally or within the Cloud, which is used to persist data for the project.</li>
  <li>A functional application ‘back-end’, written in a suitable framework of the language covered in training (Java/Spring Boot), which meets the requirements set on your Jira board. </li>
  <li>A build (.jar) of your application, including any dependencies it might need, produced using an integrated build tool (Maven). </li>
  <li>A series of API calls designed with postman, used for CRUD functionality. (Create, Read, Update, Delete) </li>
  <li>Fully designed test suites for the application you are creating, including both **unit** and **integration tests**. </li>
 </ul>
</details>

<p align="right">(<a href="#top">back to top</a>)</p>



### Built With


* [Java](https://docs.oracle.com/)
* [Spring Boot](https://docs.spring.io/)
* [Junit](https://junit.org/)
* [MySQL](https://dev.mysql.com/)
* [Mockito](https://site.mockito.org/)



<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### How I expected the challenge to go

I honestly came in to this expecting it to be incredibly stressful and difficult, picturing myself struggling at every hurdle. 
Which, while it isn't too far from what happened, once I dealt with app install issues things slowly started to piece themselves together using QA community, discussions with the trainers and some hefty use of stack overflow. 


### What went well

The CRUD functionality was fairly simple enough to implement, I ran in to a few serialization errors but it was a simple case of missing annotations. 
Setting up Jira and Git went fairly smoothly and I felt like I made good pace for the project, hitting all but 4 of the MVP targets within the first couple of days.

<p align="right">(<a href="#top">back to top</a>)</p>



## What went wrong

My MySQL install and Postman app were unresponsive for the first couple of days, which slowed things down massively until Morgan (QA Trainer) set me up with Swagger and how to use a H2 login. In hindsight I shouldn't have spent so long trying to fix those and should have used my time a little bit more effectively. 

Getting over the inital hurdle of configuring Spring Boot was a bit of a struggle, but once I broke it down into modules and attacked it in small pieces it became much more manageable. 


<p align="right">(<a href="#top">back to top</a>)</p>

<!-- ROADMAP -->
## Possible improvements for future revisions

I would like to further implement more custom exceptions and use an Error Handler, but that was a little out of the scope of my knowledge right now. 
I would also like to create a front end so that users can log in and store online recipes, and also have the ability to search for other peoples recipes. 
I could implement Patches, so that you dont have to update an entire entry each time you want to update
On that topic, it would be nice to implement a few more custom queries to allow for more explicit searching of the database

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Postman / API Screenshots

### Get All

![image](https://user-images.githubusercontent.com/81429555/152140639-963251f6-4854-446a-88b1-41dc5ad53d3c.png)

This is the code used inside the RecipeController class for a read all method, it calls on the getAll() method that exists in my RecipeService class as shown below.

 ![image](https://user-images.githubusercontent.com/81429555/152140880-c69c8291-3b4d-4339-b8a5-759c7d00602c.png)

this in and of itself is fairly simple code, it takes in a repository and returns all entries in that repo. It uses the built in findAll() method. 

  ![image](https://user-images.githubusercontent.com/81429555/152141282-afbddc96-7156-4d24-a55b-8d470fb32ea3.png)


  ![image](https://user-images.githubusercontent.com/81429555/152141307-edc5c79a-ded1-4042-b377-97bd1190ec2d.png)


So it uses the path variable I set out in my controller of '/recipe/getAll' and returns all entires with a status code of 200 ok.

<p align="right">(<a href="#top">back to top</a>)</p>
### Create Method

![image](https://user-images.githubusercontent.com/81429555/152142231-baa830a9-00ba-47a9-ac76-ed34691a094f.png)

Above is the code in the RecipeService class to add an item to the database, again fairly simple, just uses the built in .save() method. Because the save() method changes the instance of the entity, we return the saved instance.

![image](https://user-images.githubusercontent.com/81429555/152142560-b5a1f6a3-c416-4aa3-b1d8-35d1d51e8cb4.png)

Above is the code in the RecipeController class, it uses the builder design pattern. 
"create a variable recipes, that is a ResponseEntity of type RecipeBook = create a 201 okay response when successful and set the body of the response to be the addItem method within the RecipeService class and return this new variable"

![image](https://user-images.githubusercontent.com/81429555/152148249-2c16749c-3145-46d6-88b5-cc8fe714bee7.png)

so Now we can see the Path Variable of /recipe/add works, and you can see that the post request works and gives a 201 created response, as set out in the code

<p align="right">(<a href="#top">back to top</a>)</p>
## Get By ID

![image](https://user-images.githubusercontent.com/81429555/152507426-b3c0bb71-6264-45b0-ac6b-91b11b6dcf2a.png)

This is the getById method in the RecipeService Class, it uses a lambda to nest return statements, essentially acting as an in-line if/else statement. 

![image](https://user-images.githubusercontent.com/81429555/152146735-52b47b3f-f793-42d9-89ba-d4563ea54d70.png)

This is the getById method in RecipeController, it works almost identically to the add method but instead of the 201 status it uses a 200 okay response and calls the getById() method from service.  

![image](https://user-images.githubusercontent.com/81429555/152147276-4367e980-94dd-4cbc-af26-0bd146c6b5ef.png)

so now there are two entries

![image](https://user-images.githubusercontent.com/81429555/152147803-ed581c8d-6726-4687-86c7-97d2d1ba5e00.png)

and here we can see that my Path Variable of /recipe/get/2 works and retrieves the entry with an id of 2 and returns it in the repsonse body with a 200 okay response.

<p align="right">(<a href="#top">back to top</a>)</p>
### Delete By ID

![image](https://user-images.githubusercontent.com/81429555/152148526-ce6ece06-7f31-470b-b38b-e4c23410baa8.png)

this is the code in RecipeController, which follows the same pattern as the add and get methods.

![image](https://user-images.githubusercontent.com/81429555/152148905-1ac4b5ed-adb8-47ab-9f70-2a3c4cd4a915.png)

this block of code, in the RecipeService class, which essentially says "if this id exists in the repository, call the deleteById() method, else throw a RecipeNotFoundException"


![image](https://user-images.githubusercontent.com/81429555/152144347-180ceff6-c6d4-403e-9706-5124ce776b1e.png)

this image is to show that the entity exists, for the puposes of deletion

![image](https://user-images.githubusercontent.com/81429555/152144546-9d39ae54-437b-4810-841a-cddd8109d5c2.png)

So it uses my custom path variable of 'recipe/delete/1' to delete the recipe entry with the ID of '1'

![image](https://user-images.githubusercontent.com/81429555/152144992-8a23145a-b067-47ba-835d-5abcb6cbb581.png)

so now when I do the getAll request, nothing exists in the repository. 

<p align="right">(<a href="#top">back to top</a>)</p>
### Update By ID

![image](https://user-images.githubusercontent.com/81429555/152162084-8c3b565e-250d-494e-a20e-a426c49dfa54.png)

This is the updateById() method in RecipeService, which checks if the id exists in the repository, creates a new 
instance of RecipeBook and uses getByID() to set the variable.
It then makes use of my getters and setters in my RecipeBook POJO (Plain Old Java Object) to update the contents 
and makes use of the built in save() method, returning the saved entity. 

if this fails, it throws a RecipeNotFoundException

![image](https://user-images.githubusercontent.com/81429555/152162691-d950c33c-c7dc-4475-8d49-a804fabadce6.png)

This is the update method in RecipeController, it takes in two arguments of the id and the RecipeBook that is going 
to be updated.
Creates a new instance of RecipeBook, updatedRecipe, and uses the updateById() method to update the variable. 
it then returns the value of the updatedRecipe and the Http response code 202 accepted (using HttpStatus.ACCEPTED), as a RecipeBook ResponseEntity

![image](https://user-images.githubusercontent.com/81429555/152163319-b1bc0eda-e5f0-4064-bca0-1b77c594bcba.png)

So here we can see that 2 entities exist currently, id 3 has a recipe name of "Fish n Chips" but I'd like to change that to 
fish & chips

![image](https://user-images.githubusercontent.com/81429555/152163750-d5e66d2c-0ab5-4bb5-b509-4171956f852e.png)

I used my path variable of recipe/update/3 and in the body entered raw JSON to send an update (PUT) request, and recieved a 202 accepted request.

![image](https://user-images.githubusercontent.com/81429555/152164033-1c22d142-bc0f-447d-99be-460e5581e938.png)

and now you can see that when I do get all, the value of recipeName in the data entry with id 3 has changed to "Fish & CHips"


<p align="right">(<a href="#top">back to top</a>)</p>



## Database screenshots to show Data is being Persisted

![image](https://user-images.githubusercontent.com/81429555/152167493-239f5200-8e98-4b42-af28-3655cbde5b5f.png)

So this is to show that data at this present moment exists inside my local MySQL80 instance, running on port 8080, with an ID of 1 
in my application-prod.properties file I have set auto to update, so that whenever Postman makes a request, the database in SQL updates

### Create method

<a href="#create-method"> Link to the create method </a>

above is the link to the create documentation, which shows the code used for this next section.

![image](https://user-images.githubusercontent.com/81429555/152168377-ae3d2251-857d-4bdb-9eab-59b2094d018a.png)

I created a post request, entering new information and sent the request, receiving a 201 created response. 

![image](https://user-images.githubusercontent.com/81429555/152168567-4ef431a7-c762-4952-820e-9490240542f9.png)

and in SQL, the new entry appears when I SELECT * FROM RecipeBook

<p align="right">(<a href="#top">back to top</a>)</p>
### Delete

<a href="#Delete-By-ID"> Link to Delete By ID Documentation </a>

above is the link to the Delete By ID documentation, which shows the code used for this next section.

![image](https://user-images.githubusercontent.com/81429555/152168902-37533402-5023-477b-b72a-1cc28da3dcfc.png)

I now sent a delete request to my API with postman, to delete the previously created entry

![image](https://user-images.githubusercontent.com/81429555/152169029-5ecb12b9-d658-46d9-a06e-737035eabfa9.png)

and the entry has been successfully deleted from the MySQL database

<p align="right">(<a href="#top">back to top</a>)</p>
###  Update 

<a href="#Update-By-ID"> Link to Update By ID Documentation </a>

above is the link to the Update By ID documentation, which shows the code used for this next section.

![image](https://user-images.githubusercontent.com/81429555/152169513-0b223686-7369-4bc2-983e-4c950c88bc86.png)

So I've created a second entry, which now has an ID of 3 because the ID auto-increments each time a new one is created, 
regardless of previous deletions.
But now I'd like to change the details from Green pesto to Red Pesto

![image](https://user-images.githubusercontent.com/81429555/152169880-5ada24a8-7f68-4c93-901f-53761b34939a.png)

So I sent a PUT request to my API with Postman, updating Green Pesto to Red Pesto and recieved a 202 accepted request

![image](https://user-images.githubusercontent.com/81429555/152170086-e036e544-9313-4f1b-8740-00dc2a1b1590.png)

and now, as you can see, the data has changed in the MySQL database.

![image](https://user-images.githubusercontent.com/81429555/152170246-fd6c193f-0feb-4804-ab50-af8ec211f3f4.png)

![image](https://user-images.githubusercontent.com/81429555/152170288-051623df-ca20-455a-8d64-614376925a56.png)

and just as final proof, the Spring Boot app has terminated completely, but the data still exists within the MySQL database.


<p align="right">(<a href="#top">back to top</a>)</p>




## Link to my Jira board


<a href = "https://jack-middleton.atlassian.net/jira/software/projects/D7EP/boards/2/backlog?selectedIssue=D7EP-22"> My Jira board </a>

<p align="right">(<a href="#top">back to top</a>)</p>


## Testing and Coverage
### Unit Testing

![image](https://user-images.githubusercontent.com/81429555/152508578-9fd4d3ff-a71b-4d20-a38e-99e30ce5b665.png)

So this before each method is used to populate a dummy dB for use during testing, in this case Unit Testing

![image](https://user-images.githubusercontent.com/81429555/152508736-35993eed-a2ca-4e03-aff5-980d7b985ad7.png)

My Create test creates a dummy new_recipe and saved_recipe, mocks the repo.save() method, asserts that when the addItem() method is called new_recipe should be equal to saved_recipe and then verifies that the repo was accessed exactly one time.

![image](https://user-images.githubusercontent.com/81429555/152509308-8dcb3e18-4441-48cb-be4b-1a1f0e516030.png)

My GetAll test is a very simple, WHEN I run repo.findAll() runs then return the recipes database, THEN check that serivce.getALL() method is equal to the recipes database and verify the repo was accessed once using findAll

![image](https://user-images.githubusercontent.com/81429555/152509817-843c5023-61c3-4b3a-8ce7-add2bc61b6c2.png)

My delete test has to work by ID because of the way my delete method works in my service class. So I set a variable equal to the id of a variable created in @BeforeEach, mock the existsById() method to check it returns true, run the delete method and then verify that existsById and deleteById worked.

![image](https://user-images.githubusercontent.com/81429555/152510089-4f6e4fed-7a53-4d28-ae13-7b92724b782c.png)

GetById test works functionally similar to delete, first i set a variable equal to the ID of a variable in my @BeforeEach method, mock that the findById repo method returns an optional of the variable expectedRecipeWithId, assert that when the method in service runs, it is equal to the result I expected, and verify that findById works

![image](https://user-images.githubusercontent.com/81429555/152510388-bf9ecb90-bc8a-454d-aa46-0fa23ec93d3c.png)

Update works a little differently, first we have to create an ID variable as before, but then we have to create an 'expected' updated recipe variable and change it in some way to the original, I did it here using my getters and string concatenation.

I then mock all the functions within my updateById() method in the service class, that being that the existsById() method returns true, getById() returns expectedRecipeWithId() and when expectedRecipe is saved it returns the updatedRecipe

then Its just a simple case of asserting that the updateById method is equal to the dummy updated recipe I created earlier and verifying that each one of the wwhen methods works as it should

![image](https://user-images.githubusercontent.com/81429555/152511385-708380d8-0cf3-489e-9f08-6e33a4b242a0.png)

The exception tests all work functionally the same, with minor tweaks so I'll just show the deleteExceptiontest. 
This time we create a random ID not in the dB and mock that existsById returns false

then we use a lambda function to say that when this line of code runs, run the bit after the lambda arrow first, and when that fails and throws an exception (as expected), assert that it throws a RecipeNotFoundException (my custom Exception), and set vbariable x of type RecipeNotFoundException equal to that

I set a String variable equal to my custom exceptioon message and then assert that the message inside x is equal to the expected message, and then verify that existsById does infact return false. 

### Controller System Integration

I don't plan on going in to all of the tests, because the controller integration and service integration aren't too dissimilar from one another in terms of theory, but I'll run through the Controller System Integration tests so I have a resource to look back over should I need it 

![image](https://user-images.githubusercontent.com/81429555/152512213-73f2a228-f9b2-4f29-8f89-9d41a502efdc.png)

Again we use a before each to set up a dummy dB for use during testing, but this time we use the last two lines 'int size' and 'newElement' to make sure that when we create a new element in the dB, we can get its ID by getting the ID of the previous last element and adding 1, we do this because if the @Transactional annotation were to stop working and we were to start getting off by one errors, we could switch to a tear down @AfterEach method, and although the ID would continually increment, we would still always get the correct last elements ID

![image](https://user-images.githubusercontent.com/81429555/152512483-b4f39aa2-801c-4165-9ea6-8cfe7a9b574c.png)

Here we create a mock request, using the path that was outlined in the Controller 
We specify that it accepts an expected returned conttent type of application/jso0n
we use ObjectMapper to create an expected json string 
statusMatcher contains our expected response code, in this case 200 ok and contentMatcher contains our expected return content, in this case the recipes dB
and then we perform the Mock request telling it that we expect statusMatcher and contentMatcher

![image](https://user-images.githubusercontent.com/81429555/152512846-8c39c029-be7b-4eca-aacd-9dc32415f4fd.png)

![image](https://user-images.githubusercontent.com/81429555/152512858-35689972-d529-45a8-b55a-8bb8841e5b89.png)

getById are functionally the same, the only thing that changes is the path.
We get an ID from the dB and put it inside the long id variable, set up our mock request and its content type, content and accepted content type
we only need a statusMatcher, because in this case we don't care that the body of the response is exactly right, all we care about is that it found the correct ID and returned it with a status response of 200 ok, and then perform the Mock request

![image](https://user-images.githubusercontent.com/81429555/152513268-956bb7c6-5dbb-4b86-8c12-a4c788d3e45b.png)

Testing the create method was again, not too bad. 
First we create a new recipe and an expected recipe, similar to how we did in the unit testing.
then we set up our mock request, its content type, accepted content type and the content body, but this time I want the body to be the newRecipe created earlier
then we set up the statusMatcher as normal, expecting a 201 created response, and the contentMatcher this time is expecting a json string of the exppectedRecipe
Then we perform the mock request and check our expecteds.

![image](https://user-images.githubusercontent.com/81429555/152513311-91911c51-bf84-44cd-8542-9e6b3092c44b.png)

and finally, the update method

as before, we create a newRecipe and expectedRecipe variable, this time they can be the same as we are not explicitly checking whether anything changed, we just care that it returns the expectedRecipe which contains the ID. 
We then create our mock requestr, seetting the path, content type, accepted content type and expected content, create a json string equal to the expected recipe with ID and run the mock request with the expected status and content matcher





<p align="right">(<a href="#top">back to top</a>)</p>
