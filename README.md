# LangtonsAnt
A Java and LibGDX implementation of Langton's Ant

Langton's ant is a two-dimensional Turing machine with a very simple set of rules but complex emergent behavior. 
It was invented by Chris Langton in 1986 and runs on a square lattice of black and white cells.

[Langton's Ant on Wikipedia](https://en.wikipedia.org/wiki/Langton%27s_ant)

This repository is home to my attempt at a Java implementation of Langton's ant, made as a project for fun.

The program, as it stands, allows you to edit the configuration of the grid and position of the ant to run different simulations of the ant.

I'm not terribly familiar with LibGDX currently, nor am I accomplished in being entirely efficient in my code 100%
of the time, so forgive me for shortcomings, especially when it comes to managing the objects through dependency injection.

When it comes to importing this project into your IDE, roughly follow these steps:
  1. Set up your IDE for LibGDX: [Here](https://github.com/libgdx/libgdx/wiki/Setting-up-your-Development-Environment-(Eclipse,-Intellij-IDEA,-NetBeans))
  2. Either download the project or clone the repository through Github.
  3. Import into your IDE through the build.gradle file.
  You may potentially have to create a `local.properties` folder defining the position of your Android SDK through the declaration of an `sdk.dir` variable. Other problems with building should be pointed out by your IDE, and you should be able to figure them out.
