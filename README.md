# seg.jUCMNav

## Project Setup Steps
    % cd "your_eclipse_workspace"
    
    % git clone git@github.com:McGill-DP-Group/seg.jUCMNav.git seg.jUCMNav

Or if you haven't setup a ssh key you can use https with your github username and password

    % git clone git@github.com:McGill-DP-Group/seg.jUCMNav.git seg.jUCMNav

note: the project folder must be named "seg.jUCMNav", otherwise there will be some errors, even though the errors affect nothing, they just make you feel uncomfortable.

    % cd seg.jUCMNav

In your Eclipse:

  1. File->Import..
  2. Choose "Existing Projects into Workspace -> click next
  3. In "Select root directory" choose the seg.jUCMNav folder just cloned and click finish
  4. Run as "Eclipse Application" to open a new eclipse with the lasted build jUCMNav plugin
  5. Run as "Junit Plug-in test" to run all the test suites.

## Features to be implemented

  1. Add support for feature model diagram and evaluation.
    a. Add new interface for creating feature model diagram.
    b. Add new evaluation mechanism for feature model diagram.
  2. Support Object Constraint Language (OCL) in feature modeling
    a. Support at least two type of constraints: Requires & Conflicts.
    b. Add interface for describing such constraints in feature model diagram
    c. Update feature model evaluation mechanism to handle constraints in feature model.
  3. Support advanced Mode in jUCMNav for Feature Modeling.
  4. Add documentations on the jUCMNav TWiki page.
  5. Transform feature model to concern-oriented design model.
  6. Support for new Concern-Oriented Metamodel
    


