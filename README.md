#seg.jUCMNav
##Project Setup Steps
    % cd "your_eclipse_workspace"
    
    % git clone git@github.com:<github username>/seg.jUCMNav.git seg.jUCMNav

Or if you haven't setup a ssh key you can use https with your github username and password

    % git clone https://github.com/<github username>/seg.jUCMNav.git seg.jUCMNav

note: the project folder must be named "seg.jUCMNav", otherwise there will be some errors, even though the error affects nothing, it just makes you feel uncomfortable.

    % cd seg.jUCMNav

In your Eclipse:

  1. File->Import..
  2. Choose "Existing Projects into Workspace -> click next
  3. In "Select root directory" choose the seg.jUCMNav folder just cloned and click finish
  4. Run as "Eclipse Application" to open a new eclipse with the lasted build jUCMNav plugin
  5. Run as "Junit Plug-in test" to run all the test suites.

##Features to be implemented
