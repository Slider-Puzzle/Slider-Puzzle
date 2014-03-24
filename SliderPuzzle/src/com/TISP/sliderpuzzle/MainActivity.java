package com.TISP.sliderpuzzle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	Button[] buttons = new Button[9];
	TextView textView_message;
	int size = 9;	
	Game game = new Game(buttons, textView_message);
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		// LIST OF SLIDER TILES
		// ---------------------------------------------------------------------
        // The buttons (tiles) in the app are added to a list below. The button
        // you just added is the last one in the list!
		
		// List of slider tiles:
        
		game.buttons[0] = (Button) findViewById(R.id.button1);
		game.buttons[1] = (Button) findViewById(R.id.button2);
		game.buttons[2] = (Button) findViewById(R.id.button3);
		game.buttons[3] = (Button) findViewById(R.id.button4);
		game.buttons[4] = (Button) findViewById(R.id.button5);
		game.buttons[5] = (Button) findViewById(R.id.button6);
		game.buttons[6] = (Button) findViewById(R.id.button7);
		game.buttons[8] = (Button) findViewById(R.id.button9);
		
		// your button:
		// -----------------------------------------------------
		// Delete the "//" to add it to the list above!
		
		// game.buttons[7] = (Button) findViewById(R.id.button8);
				
		initialize();
		game.message = (TextView) findViewById(R.id.textView_message);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    // BUTTON ACTIONS
    // ---------------------------------------------------------------------
    // These actions get executed when a button is clicked.  There are two types
    // of buttons the user can click in this app - the "New Game" button and 
    // one of the slider tiles. What do you think should happen for each action?
    
    
	public void clickNewGame(View v)
	{
		// What action do you think should happen here?
		// ------------------------------------------------
		// Pick the best one and delete the "//" to add it to the code!
		
		// game.startNewGame();
		// game.checkForWin();
		// game.closeTheApp();
	}
		
	public void clickSliderTile(View tile)
	{
		// What action do you think should happen here?
		// ------------------------------------------------
		// Pick the best one and delete the "//" to add it to the code!
		
		// game.endGame();
		// game.tryToMoveTile(tile);
		// game.shuffleAllTiles();
	}
	
	// ---------------------------------------------------------------------
	
	// sets the buttons as un-clickable until a new game is started
	public void initialize()
	{
		for (int i = 0; i < size; i++)
			game.buttons[i].setClickable(false);
	}
}
