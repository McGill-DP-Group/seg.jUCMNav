seg.jUCMNav
===========
#Project Setup Steps
1.%cd "your_eclipse_workspace"


2.%git clone git@github.com:<github username>/seg.jUCMNav.git seg.jUCMNav

  or if you haven't setup a ssh key you can use https with your github username and password

  %git clone https://github.com/<github username>/seg.jUCMNav.git seg.jUCMNav

  note: the project folder must be named "seg.jUCMNav", otherwise there will be some errors, even though the error affects nothing, it just makes you feel uncomfortable.


3.%cd seg.jUCMNav


4.In your Eclipse:

  1)File->Import..

  2)Choose "Existing Projects into Workspace -> click next

  3)In "Select root directory" choose the seg.jUCMNav folder just cloned and click finish


5. Run as "Eclipse Application" to open a new eclipse with the lasted build jUCMNav plugin

   Run as "Junit Plug-in test" to run all the test suites.
