package com.TISP.sliderpuzzle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game {
	
	// These are values that Game keeps track of to make decisions
	// and change the appearance of the user interface.
	public Button[] buttons = new Button[9];
	public TextView message;
	private int[] positions = new int[9];
	private int size = 9;
	private boolean gameOver = false;
	private int buttonClickedIndex = 0;
	private int emptyLocationIndex = 0;
	
	Game(Button[] inButtons, TextView inTextView)
	{
		buttons = inButtons;
		message = inTextView;
		
		for (int i = 0; i < size; i++)
		{
			positions[i] = i + 1;
		}
	}

	
	// STARTING A NEW GAME:
	// ---------------------------------------------------------------------
	// These actions are called when the user clicks on the "New Game" button.
	// When the user starts a new game, what should happen?
	
	public void startNewGame()
	{
		// reset game variables
		gameOver = false;
		
		// What action do you think should happen here?
		// ------------------------------------------------
		// Pick the best one and delete the "//" to add it to the code!
		
		// tryToMoveTile();
		// createListOfRandomTilePositions();
		// shuffleAllTiles();
		
		// ------------------------------------------------
		
		// set tiles to "unlocked"
		for (int i = 0; i < size; i++)
			buttons[i].setClickable(true);
		
		// clear message box of prompts
		message.setText("");
	}
	
	
	// SHUFFLING THE TILES:
	// ---------------------------------------------------------------------
	// Every time the tiles are shuffled they are moved into random places.
	// To shuffle the tiles, what does the computer need to know?
		
	private void shuffleAllTiles()
	{
		// What action do you think should happen here?
		// ------------------------------------------------
		// Pick the best one and delete the "//" to add it to the code!
		
		// swapTwoTiles();
		// createListOfRandomTilePositions();
		// checkForWin();
		
		// ------------------------------------------------
		
		//populate buttons w/ random numbers
		for (int i = 0; i < size; i++)
		{
			// reset button visibility
			buttons[i].setVisibility(View.VISIBLE);
			buttons[i].setText(String.format("%d", positions[i]));
			if (positions[i] == 9)
				buttons[i].setVisibility(View.INVISIBLE);
		}	
	}
	
	
	// DURING THE GAME:
	// ---------------------------------------------------------------------
	// Whenever a tile is clicked, the game needs to decide how to move it.
	// This action will happen an unknown number of times until the player wins
	// the game or they give up and start a new one.
	
	public void tryToMoveTile(View tile)
	{
		// identify which tile was clicked
		for (int i = 0; i < size; i++)
		{
			if (tile.getId() == buttons[i].getId())
			{
				// Id's matched - tile i was clicked
				buttonClickedIndex = i;
				break;
			}
		}
		
		// What is the first thing the game should check when moving a tile?
		// -----------------------------------------------------------------
		// Pick the best one and delete the "//" to add it to the code!
		
		// checkIfTileCanMove();
		// swapTwoTiles();
		// checkForWin();
		
		// ------------------------------------------------
		
		
		// If an empty space is available (the tile can move!)
		if (emptyLocationIndex != -1)
		{
			
			// If the tile can move, how can we move it?
			// ------------------------------------------------
			// Pick the best one and delete the "//" to add it to the code!
			
			// checkIfTileCanMove();
			// swapTwoTiles();
			// gameOver();
			
			// ------------------------------------------------
		}
		
		
		// After moving the tiles, what else should we check for?
		// ------------------------------------------------
		// Pick the best one and delete the "//" to add it to the code!
		
		// checkIfTileCanMove();
		// gameOver();
		// checkForWin();
		
		// ------------------------------------------------
	}
	
	
	// THE END OF THE GAME:
	// ---------------------------------------------------------------------
	// The program must check to see if the player won the game after each move.
	// If all of the tiles are in the right place, how does the program
	// end the game?
			
	private void checkForWin()
	{			
		// assume game is won
		boolean win = true;
		
		// check the order of the tiles:
		for (int i = 0; i < size; i++)
		{
			// if any tile is out of order, game is NOT won
			if (positions[i] != i + 1)
			{
				win = false;
				break;
			}
		}
		
		// evaluate result of check
		if (win)
		{
			gameOver = true;
		
			// If the game is over (gameOver = true), what should we do?
			// ----------------------------------------------------------
			// Pick the best one and delete the "//" to add it to the code!
			
			// swapTwoTiles();
			// checkForWin();
			// gameOver();
			
			// ------------------------------------------------	
		}
	}
	
	
	// =============================================================================
	// THE REMAINING CODE:
	// =============================================================================
	// Everything below this line has already been completed for you.  This includes
	// the random number generator that creates a list of new tile positions and the
	// code that swaps two tiles on the screen. While you don't have to change any
	// of the code below, feel free to read through it and see if you can understand
	// how it works!
	
	
	// gameOver()
	// ---------------------------------------------------------------------
	// This function cleans up the program when the game is over. It locks
	// the buttons in place so the user cannot continue to move them and it
	// messages the user telling them they have won.
	
	private void gameOver()
	{		
		// set tiles to "locked"
		for (int i = 0; i < size; i++)
			buttons[i].setClickable(false);
		
		// update user message
		message.setText(R.string.playAgainMessage);
	}
	
	
	// checkIfTileCanMove()
	// ---------------------------------------------------------------------
	// This function checks tiles surrounding the tile that was clicked to
	// see if they are empty.
	
	// Function to check if the tile can be moved
	private int checkIfTileCanMove()
	{	
		// identify potential locations to move to
		int[] locationsToCheck = new int[4];
		locationsToCheck[0] = buttonClickedIndex - 3; // above
		locationsToCheck[1] = buttonClickedIndex + 3; // below
		locationsToCheck[2] = buttonClickedIndex - 1; // to left
		locationsToCheck[3] = buttonClickedIndex + 1; // to right
		
		if (buttonClickedIndex == 2 || buttonClickedIndex == 5) {
			// these buttons are special cases where buttonClickedIndex + 1 can actually be a free space
			locationsToCheck[3] = -1; // negative index is automatically invalid
		}
		
		// check the valid locations specified above
		for (int i = 0; i < 4; i++)
		{
			// can only check valid indeces (>=0)
			if (locationsToCheck[i] >= 0 && locationsToCheck[i] < 9)
			{
				if (buttons[locationsToCheck[i]].isShown() == false)
				{
					// button occupying location is invisible, e.g. empty space
					emptyLocationIndex = locationsToCheck[i];
					return locationsToCheck[i];
				}
			}			
		}
		emptyLocationIndex = -1;
		return -1; // -1: flag for no empty locations found
	}
	
	
	// swapTwoTiles()
	// ---------------------------------------------------------------------
	// This function swaps two tiles. The tiles do not actually move on the
	// screen. When a tile "moves", the location it was in becomes INVISIBLE,
	// while the location it moves to becomes VISIBLE and gets the number
	// of the tile moving there!
	
	private void swapTwoTiles()
	{		
		// "move" tile to blank space:
		
		// make current tile invisible
		buttons[buttonClickedIndex].setVisibility(View.INVISIBLE);
		
		// set the adjacent empty tile to number of the tile that is moving
		buttons[emptyLocationIndex].setText(buttons[buttonClickedIndex].getText());
		
		// make the new tile visible
		buttons[emptyLocationIndex].setVisibility(View.VISIBLE);
		
		// swap the tile positions in memory
		int temp = positions[emptyLocationIndex];
		positions[emptyLocationIndex] = positions[buttonClickedIndex];
		positions[buttonClickedIndex] = temp;
	}


	// createListOfRandomTilePositions()
	// ---------------------------------------------------------------------
	// This function will generate a list of 9 numbers (1-9) in a random order.
	
	private void createListOfRandomTilePositions()
	{		
		// To shuffle an array a of n elements (indices 0..n-1):
		for (int i = size - 1; i >= 1; --i)
		{
			// generate a random position in the array
			int j = (int)(Math.random() * size);
		  
			// swap elements
			int temp = positions[j];
			positions[j] = positions[i];
			positions[i] = temp;
		}
	}
}

