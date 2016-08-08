# JavaGameFramework v2.0
A simple game framework written in Java. Provides a fully functional game loop, as well animation/modeling classes that can be used in developing basic 2D games.

Purpose of this framework: to provide a collection of game-independent classes that will help to perform basic tasks that every game needs to perform, such as implementing a game screen, drawing animated objects/sprites to the screen, as well as handling player input.

- Does not provide any Game-specific classes. (such as characters, levels, maps, sprites, ect). This simply provides a basic game engine

*********************
Location of Framework
*********************
- Location of framework is stored in 2DGameFramework/src/com/molinab


Breakdown of provided classes:
************
Main classes
************
- GameMain: Starting point for the game. This class provides the main method which will set a game into motion.
- Game: The central class for a game. The game class will host the game loop, and will have methods to start and exit out of the game.
- Resources: A convenience class that will allow the ability to easily load image and sound files, and use them anywhere within the program.

*************
Model classes
*************
- Scrollable: This class is a useful tool that can used to give objects (such as towers, sprites, backgrounds, ect) a parallax effect. It requires the Vector2D class (from com.molinab.framework.math.Vector2D), in order to generate the desired effect.
- ScrollHandler: handles any object that needs to have a scrolling effect throughout the game.

*************
State classes
*************
- State: A game is built one state at a time. Each state represents one screen in the game. The State class serves as a blueprint for other states (through inheritance).
- LoadState: State will resources load
- MenuState: A "welcome" screen that displays information regarding the game. It is used to allow navigation to future game states, such as the GameState (written by whomever), where gameplay happens.

***************
Utility classes
***************
- InputHandler: Listens for user mouse and keyboard events and dispatches the game's state classes to handle these events.
- RandomNumberGenerator: provides multiple ways of generating a random number, which is useful in developing many different types of games

************
Math classes
************
- Vector2D : 

*****************
Animation classes
*****************
- Animation: handles all animated objects in the game by accepting Frame objects, storing them in an array and storing their corresponding durations in a separate array, and then allows them to be rendered to the screen.
- Frame: handles each individual picture of an animation. (An animation consists of multiple pictures to allude the sense of actual movement). A Frame object(s) is instantiated and is sent to Animation(Frame... frames), where it is then rendered to the screen.

