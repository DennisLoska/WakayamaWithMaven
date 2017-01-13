
import static org.junit.Assert.*;

import game.Game;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a game.game System Tests - it tests the
 * whole game and the endpoints between user input
 * and output to the console.
 * <p>
 * The original
 *
 * @author Barne Kleinen
 */
public class GameSystemTest {
    private Game game;

    public GameSystemTest() {

    }

    /**
     * Sets up the test fixture.
     * <p>
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testQuit() {
        //given: new game
        //when
        String output = game.processCommand("quit");
        //then
        assertEquals(
                "null is the output that signals that the main loop should stop",
                null, output);
    }

    @Test
    public void testHelp() {
        //given: new game
        //when
        String output = game.processCommand("help");
        //then
        assertTrue("should print help message containing command words", output.contains("command words"));
        assertTrue("message contains command word go", output.contains("go"));
        assertTrue("message contains command word quit", output.contains("quit"));
        assertTrue("message contains command word help", output.contains("help"));
    }

    @Test
    public void testGoSouth() {
        //given: new game
        //when
        String output = game.processCommand("go south");
        //then
        assertTrue("should be in computing lab" + output,
                output.contains("this wall looks suspicious..."));
    }

    @Test
    public void testGoNorth() {
        //given: new game
        //when
        String output = game.processCommand("go north");
        //then
        assertEquals(true, output.contains("at an abandoned bridge that looks spooky"));
    }

    /**
     * version 1: manual test case
     */
    @Test
    public void testGoWithoutDirection() {
        //given: new game
        //when
        String output = game.processCommand("go");
        //then
        assertEquals(true, output.contains("Go where"));
    }

    /**
     * version 2: recorded test case
     */
    @Test
    public void goWODirectionShouldShowError() {
        assertEquals("Go where?", game.processCommand("go"));
    }

    @Test
    public void completeWalkthrough() {
        goAndSee("east", "library");
        goAndSee("up", "hallway");
        goAndSee("east", "storage room");
        goAndSee("east", "room a");
        goAndSee("north", "room c");
        goAndSee("south", "room a");
        goAndSee("south", "room b");
        goAndSee("north", "room a");
        goAndSee("west", "storage room");
        goAndSee("west", "hallway");
        goAndSee("down", "library");
        goAndSee("west", "temple entrance");
        goAndSee("south", "this wall looks suspicious");
        goAndSee("north", "temple entrance");
        goAndSee("west", "toilets");
        goAndSee("down", "cellar");
        goAndSee("east", "atelier");
        goAndSee("west", "cellar");
        goAndSee("up", "toilets");
        goAndSee("east", "temple entrance");
        goAndSee("north", "bridge");
        goAndSee("north", "forrest");
        goAndSee("north", "forrest entrance");
        goAndSee("east", "closed shops");
        goAndSee("west", "forrest entrance");
        goAndSee("north", "train station");
        goAndSee("north", "s45");
        goAndSee("south", "train station");
        goAndSee("south", "forrest entrance");
        goAndSee("south", "forrest");
        goAndSee("south", "bridge");
        goAndSee("south", "temple entrance");
    }

    private void goAndSee(String direction, String whatShouldBeContained) {
        //when
        String result = game.processCommand("go " + direction);
        //then
        if (!result.contains(whatShouldBeContained))
            fail(result + " does not contain " + whatShouldBeContained);
    }

    @Test
    public void showExits() {
        game.processCommand("go south");
        String result = game.processCommand("go north");
        assertTrue(result.contains("east"));
        assertTrue(result.contains("south"));
        assertTrue(result.contains("west"));
    }

    @Test
    public void showCommands() {
        game.processCommand("go south");
        String result = game.processCommand("go north");
        assertTrue(result.contains("east"));
        assertTrue(result.contains("south"));
        assertTrue(result.contains("west"));
    }

    @Test
    public void goUp() {
        game.processCommand("go east");
        String result = game.processCommand("go up");
        assertTrue(result.contains("down"));
        assertTrue(result.contains("east"));
    }

    @Test
    public void goDown() {
        game.processCommand("go west");
        String result = game.processCommand("go down");
        assertTrue(result.contains("up"));
        assertTrue(result.contains("east"));
    }

    @Test
    public void showItemDescriptions(){
        game.processCommand("go east");
        //currentroom is now the library with 3 items in it
        String result = game.processCommand("look");
        assertTrue(result.contains("There is a scroll."));
        assertTrue(result.contains("It is an apple - it should taste good."));
        assertTrue(result.contains("It is some sort of a key."));
    }

    @Test
    public void goBackAtGameStart(){
        String result = game.processCommand("back");
        assertTrue(result.contains("the temple entrance"));
    }

    @Test
    public void goBackToRoom(){
        game.processCommand("go east");
        String result = game.processCommand("back");
        assertTrue(result.contains("the temple entrance"));

    }
}
