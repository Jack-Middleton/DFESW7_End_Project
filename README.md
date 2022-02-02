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
      <a href="#about-the-project">About The Project</a>
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


<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### How I expected the challenge to go

I Honestly came in to this expecting it to be incredibly stressful and difficult, picturing myself struggling at every hurdle. 
Which, while it isn't too far from what happened, once I dealt with app install issues things slowly started to piece themselves together using QA community, discussions with the trainers and some hefty use of stack overflow. 


### What went well

The CRUD functionality was fairly simple enough to implement, ran in to a few serialization errors but it was a simple case of missing annotations. 
Setting up Jira and Git went fairly smoothly and I felt like I made pretty good pace for the project, hitting all but 4 of the MVP targets within the first couple of days (with a few late nights thrown in but y'know)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## What went wrong

My MySQL install and Postman app completely fried for the first couple of days, which slowed things down massively until Morgan set me up with Swagger and how to use a H2 login, in hindsight I shouldn't have spent so long trying to fix those and should have used my time a little bit more effectively. 

Getting over the inital hurdle of configuring Spring Boot was a bit of a struggle, but once I broke it down into modules and attacked it in small pieces it became much more manageable. 




<!-- ROADMAP -->
## Possible improvements for future revisions

I would like to further implement more custom exceptions and use an Error Handler, but that was a little out of the scope of my knowledge right now. 
I would also like to create a front end so that users can log in and store online recipes, and also have the ability to search for other peoples recipes. 
I could implement Patches, so that you dont have to update an entire entry each time you want to update
On that topic, it would be nice to implement a few more custom queries to allow for more explicit searching of the database

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Postman / API Screenshots
<div>
![image](https://user-images.githubusercontent.com/81429555/152140639-963251f6-4854-446a-88b1-41dc5ad53d3c.png)
  </div>
This is the code used inside the RecipeController class for a read all method, it calls on the getAll() method that exists in my RecipeService class as shown below.
<div>
  ![image](https://user-images.githubusercontent.com/81429555/152140880-c69c8291-3b4d-4339-b8a5-759c7d00602c.png)
  </div>
this in and of itself is fairly simple code, it takes in a repository and returns all entries in that repo. It uses the built in findAll() method. 
<div>
  ![image](https://user-images.githubusercontent.com/81429555/152141282-afbddc96-7156-4d24-a55b-8d470fb32ea3.png)
  </div>
<div>
  ![image](https://user-images.githubusercontent.com/81429555/152141307-edc5c79a-ded1-4042-b377-97bd1190ec2d.png)
  </div>
So it uses the path variable I set out in my controller of '/recipe/getAll' and returns all entires with a status code of 200 ok.


<p align="right">(<a href="#top">back to top</a>)</p>



<!-- LICENSE -->
## Database screenshots to show Data is being Persisted


<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTACT -->
## Link to my Jira board


<a href = "https://jack-middleton.atlassian.net/jira/software/projects/D7EP/boards/2/backlog?selectedIssue=D7EP-22"> Jira board </a>

<p align="right">(<a href="#top">back to top</a>)</p>




