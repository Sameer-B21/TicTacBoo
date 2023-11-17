import java.applet.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends Applet implements ActionListener
{

    //For screens
    Panel p_card;
    Panel card1, card2, card3, card4, card5;
    CardLayout cdLayout = new CardLayout ();

    //Game screen
    JLabel turnPic, quest, tn, xwin, ywin, xloss, yloss, tie, dp, vp, up, down;
    JButton a, b, c, d, ee, f, g, h, i, j, easy, med, hard;
    char board[] [] = {{'b', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'}};
    int turn = 1, sx = 0, so = 0, st = 0, answer, n = 10, s = (int) (Math.random () * n), t = (int) (Math.random () * n);
    char flip = 'x';
    JTextField choice, name, name2, first, ans;
    String nm1, nm2;
    Image bkgd = Toolkit.getDefaultToolkit ().createImage ("vampBack.jpg");

    //Formatting
    Color backgroundColour = Color.black;
    Color buttonColour = Color.black;
    Color buttonText = Color.red;
    Color titleColour = Color.red;
    Font titleFont = new Font ("Arial", Font.PLAIN, 30);
    Font promptFont = new Font ("Arial", Font.PLAIN, 20);
    Dimension boardSquare = new Dimension (96, 96);
    Border bored = BorderFactory.createLineBorder (Color.RED);

    public void init ()
    {//initiallizing all the screen
	p_card = new Panel ();

	p_card.setLayout (cdLayout);
	opening ();
	instructions ();
	settings ();
	gameScreen ();
	recordScreen ();
	resize (350, 520);//the size of the gamescreen
	setLayout (new BorderLayout ());
	add ("Center", p_card);
    }


    public void level ()
    { //method to change the level of the quiz
	s = (int) (Math.random () * n);
	t = (int) (Math.random () * n);

    }


    public void opening ()
    { //The first screen that the user sees
	card1 = new Panel ();
	card1.setBackground (Color.black);

	JLabel title = new JLabel (createImageIcon ("intro.png"));
	JLabel title2 = new JLabel (createImageIcon ("eyes.JPG"));
	JButton next = new JButton ("Enter");
	next.setPreferredSize (new Dimension (300, 30));
	next.setActionCommand ("2");
	next.addActionListener (this);
	next.setBackground (Color.black);
	next.setForeground (Color.red);
	next.setBorder (bored);
	JLabel img = new JLabel (createImageIcon ("whitebats.jpg"));
	card1.add (title);
	card1.add (title2);
	card1.add (img);
	card1.add (next);

	p_card.add ("1", card1);
    }


    public void instructions ()
    { //The main menu and starter screen with the context and instructions
	card2 = new Panel ();
	card2.setBackground (backgroundColour);
	JLabel title = new JLabel ("The Instructions");
	title.setFont (titleFont);
	title.setForeground (titleColour);
	Panel p = new Panel ();
	JButton settings = new JButton ("Settings");
	settings.setActionCommand ("3");
	settings.addActionListener (this);
	settings.setPreferredSize (new Dimension (150, 50));
	settings.setBackground (buttonColour);
	settings.setForeground (buttonText);
	JButton gameScreen = new JButton ("Game");
	gameScreen.setActionCommand ("4");
	gameScreen.addActionListener (this);
	gameScreen.setPreferredSize (new Dimension (150, 50));
	gameScreen.setBackground (buttonColour);
	gameScreen.setForeground (buttonText);
	JLabel inst = new JLabel (createImageIcon ("instructions.png")); //the written instructions

	card2.add (title);
	p.add (settings);
	p.add (gameScreen);
	card2.add (p);
	card2.add (inst);
	p_card.add ("2", card2);
    }


    public void settings ()
    { //Setting up the user settings and game level
	card3 = new Panel ();
	card3.setBackground (backgroundColour);
	JLabel title = new JLabel ("Choose your settings:");
	title.setFont (titleFont);
	title.setForeground (titleColour);

	Panel p = new Panel ();
	JLabel namePmt = new JLabel ("DeadPool:");
	namePmt.setFont (promptFont);
	namePmt.setForeground (titleColour);
	name = new JTextField (10); //the name of p1
	name.setFont (promptFont);

	Panel p1 = new Panel ();
	JLabel namePmt2 = new JLabel ("Vampire:");
	namePmt2.setFont (promptFont);
	namePmt2.setForeground (titleColour);
	name2 = new JTextField (10); //the name of p2
	name2.setFont (promptFont);

	tn = new JLabel ("Who goes first?");
	tn.setFont (promptFont);
	tn.setForeground (titleColour);
	tn.setPreferredSize (new Dimension (150, 30));

	JButton gen = new JButton ("Randomly Generate Turns");
	gen.setActionCommand ("gen");
	gen.addActionListener (this);
	gen.setPreferredSize (new Dimension (300, 40));
	gen.setBackground (buttonColour);
	gen.setForeground (buttonText);

	JButton entrance = new JButton ("To the game");
	entrance.setActionCommand ("4");
	entrance.addActionListener (this);
	entrance.setPreferredSize (new Dimension (300, 40));
	entrance.setBackground (buttonColour);
	entrance.setForeground (buttonText);
	JLabel t = new JLabel (createImageIcon ("teeth.jpg"));
	
	//user interface to choose the level
	Panel p2 = new Panel ();
	JLabel des = new JLabel ("Choose the level of difficulty");
	des.setForeground (titleColour);
	des.setFont (promptFont);
	easy = new JButton ("Easy");
	easy.addActionListener (this);
	easy.setActionCommand ("easy");
	easy.setBackground (buttonColour);
	easy.setForeground (buttonText);
	med = new JButton ("Medium");
	med.addActionListener (this);
	med.setActionCommand ("med");
	med.setBackground (buttonColour);
	med.setForeground (buttonText);
	hard = new JButton ("Hard");
	hard.addActionListener (this);
	hard.setActionCommand ("hard");
	hard.setBackground (buttonColour);
	hard.setForeground (buttonText);
	nm1 = name.getText ();
	nm2 = name2.getText ();

	card3.add (title);
	p.add (namePmt);
	p.add (name);
	p1.add (namePmt2);
	p1.add (name2);
	card3.add (p);
	card3.add (p1);
	card3.add (des);
	p2.add (easy);
	p2.add (med);
	p2.add (hard);
	card3.add (p2);
	card3.add (tn);
	card3.add (gen);
	card3.add (entrance);
	card3.add (t);
	p_card.add ("3", card3);
    }






    public void upDateSquare (int x, int y, JButton square)
    {
	//updates teh tiles everytime they are clicked on
	if (board [x] [y] == 'b')
	{
	    board [x] [y] = flip;
	    square.setIcon (createImageIcon (flip + ".png"));
	    flipTurn ();
	    s = (int) (Math.random () * n);
	    t = (int) (Math.random () * n);
	    quest.setText ("Solve: " + s + " X " + t);
	}
    }


    public void enable ()
    {//enabling all the buttons on gamescreen
	a.setEnabled (true);
	b.setEnabled (true);
	c.setEnabled (true);
	d.setEnabled (true);
	ee.setEnabled (true);
	f.setEnabled (true);
	g.setEnabled (true);
	h.setEnabled (true);
	i.setEnabled (true);
    }


    public void disable ()
    {//disabling the buttons
	a.setEnabled (false);
	b.setEnabled (false);
	c.setEnabled (false);
	d.setEnabled (false);
	ee.setEnabled (false);
	f.setEnabled (false);
	g.setEnabled (false);
	h.setEnabled (false);
	i.setEnabled (false);
    }


    public void win ()
    {//the win condition
	char winner = 'n';
	if (board [0] [0] == board [0] [1] && board [0] [0] == board [0] [2] && board [0] [0] != 'b')
	    winner = board [0] [0];
	else if (board [1] [0] == board [1] [1] && board [1] [0] == board [1] [2] && board [1] [0] != 'b')
	    winner = board [1] [0];
	else if (board [2] [0] == board [2] [1] && board [2] [0] == board [2] [2] && board [2] [0] != 'b')
	    winner = board [2] [0];
	else if (board [0] [1] == board [1] [1] && board [0] [1] == board [2] [1] && board [0] [1] != 'b')
	    winner = board [0] [1];
	else if (board [0] [2] == board [1] [2] && board [0] [2] == board [2] [2] && board [0] [2] != 'b')
	    winner = board [0] [2];
	else if (board [0] [0] == board [1] [0] && board [0] [0] == board [2] [0] && board [0] [0] != 'b')
	    winner = board [0] [0];
	else if (board [0] [0] == board [1] [1] && board [0] [0] == board [2] [2] && board [0] [0] != 'b')
	    winner = board [0] [0];
	else if (board [2] [0] == board [1] [1] && board [2] [0] == board [0] [2] && board [2] [0] != 'b')
	    winner = board [2] [0];
	else if (board [0] [0] != 'b' && board [0] [1] != 'b' && board [0] [2] != 'b' && board [1] [0] != 'b' && board [1] [1] != 'b' && board [1] [2] != 'b' && board [2] [0] != 'b' && board [2] [1] != 'b' && board [2] [2] != 'b')
	    winner = 't';
	
	    //shows a textbox everytime someone wins or ties
	if (winner == 'x')
	{
	    JOptionPane.showMessageDialog (null, "Vampire Wins");
	    sx++;
	}
	else if (winner == 'o')
	{
	    JOptionPane.showMessageDialog (null, "DeadPool Wins");
	    so++;
	}
	else if (winner == 't')
	{
	    JOptionPane.showMessageDialog (null, "Tie");
	    st++;
	}
	updatewinner ();
    }


    public void flipTurn ()
    {//switching turns after each turn
	if (flip == 'x')
	{
	    flip = 'o';
	    turnPic.setIcon (createImageIcon ("oturn.png"));
	}
	else
	{
	    flip = 'x';
	    turnPic.setIcon (createImageIcon ("xturn.png"));
	}
	disable ();
    }


    public void generate ()
    {//generating randomly the first person to start
	nm1 = name.getText ();
	nm2 = name2.getText ();
	int x = (int) (Math.random () * 2);
	if (x == 1)
	{
	    tn.setText ("First: "+nm1);
	    if (flip == 'o')
		flip = 'x';
	}
	else if (x == 0)
	{
	    tn.setText ("First: "+nm2);
	    if (flip == 'x')
		flip = 'o';
	}
    }


    public void gameScreen ()
    { //game screen setup

	card4 = new Panel ();
	card4.setBackground (backgroundColour);
	JLabel title = new JLabel ("Tic-Tac-BOO!");
	title.setFont (titleFont);
	title.setForeground (titleColour);
	
	//whose turn is it
	Panel p = new Panel ();
	JLabel curturn = new JLabel ("Current Turn:");
	curturn.setFont (promptFont);
	curturn.setForeground (titleColour);
	turnPic = new JLabel (createImageIcon (flip + "turn.png"));
	turnPic.setPreferredSize (new Dimension (100, 80));
	p.add (curturn);
	p.add (turnPic);

	// the math quiz part
	Panel p1 = new Panel ();
	s = (int) (Math.random () * n);
	t = (int) (Math.random () * n);
	quest = new JLabel ("Solve: " + s + " X " + t);
	quest.setForeground (Color.red);
	quest.setPreferredSize (new Dimension (80, 20));
	p1.add (quest);
	ans = new JTextField (3);
	ans.setFont (promptFont);
	p1.add (ans);
	j = new JButton ("Enter");
	j.setBackground (buttonColour);
	j.setForeground (buttonText);
	j.addActionListener (this);
	j.setActionCommand ("j");
	p1.add (j);

	//the tictactoe Buttons
	Panel p2 = new Panel (new GridLayout (3, 3));
	p2.setBackground (backgroundColour);
	a = new JButton (createImageIcon ("b.png"));
	a.setActionCommand ("a");
	a.setBackground (backgroundColour);
	a.setPreferredSize (boardSquare);
	a.addActionListener (this);
	p2.add (a);
	b = new JButton (createImageIcon ("b.png"));
	b.setActionCommand ("b");
	b.setBackground (backgroundColour);
	b.setPreferredSize (boardSquare);
	b.addActionListener (this);
	p2.add (b);
	c = new JButton (createImageIcon ("b.png"));
	c.setActionCommand ("c");
	c.setBackground (backgroundColour);
	c.setPreferredSize (boardSquare);
	c.addActionListener (this);
	p2.add (c);
	d = new JButton (createImageIcon ("b.png"));
	d.setActionCommand ("d");
	d.setBackground (backgroundColour);
	d.setPreferredSize (boardSquare);
	d.addActionListener (this);
	p2.add (d);
	ee = new JButton (createImageIcon ("b.png"));
	ee.setActionCommand ("ee");
	ee.setBackground (backgroundColour);
	ee.setPreferredSize (boardSquare);
	ee.addActionListener (this);
	p2.add (ee);
	f = new JButton (createImageIcon ("b.png"));
	f.setActionCommand ("f");
	f.setBackground (backgroundColour);
	f.setPreferredSize (boardSquare);
	f.addActionListener (this);
	p2.add (f);
	g = new JButton (createImageIcon ("b.png"));
	g.setActionCommand ("g");
	g.setBackground (backgroundColour);
	g.setPreferredSize (boardSquare);
	g.addActionListener (this);
	p2.add (g);
	h = new JButton (createImageIcon ("b.png"));
	h.setActionCommand ("h");
	h.setBackground (backgroundColour);
	h.setPreferredSize (boardSquare);
	h.addActionListener (this);
	p2.add (h);
	i = new JButton (createImageIcon ("b.png"));
	i.setActionCommand ("i");
	i.setBackground (backgroundColour);
	i.setPreferredSize (boardSquare);
	i.addActionListener (this);
	p2.add (i);

	//Game screen buttons to go to other screens and restart the game
	Panel p3 = new Panel ();
	JButton reset = new JButton ("Again");
	reset.addActionListener (this);
	reset.setActionCommand ("reset");
	reset.setPreferredSize (new Dimension (70, 30));
	reset.setBackground (buttonColour);
	reset.setForeground (buttonText);
	p3.add (reset);
	JButton instruct = new JButton ("Instructions");
	instruct.addActionListener (this);
	instruct.setActionCommand ("instruct");
	instruct.setPreferredSize (new Dimension (105, 30));
	instruct.setBackground (buttonColour);
	instruct.setForeground (buttonText);
	p3.add (instruct);
	JButton settings = new JButton ("Settings");
	settings.addActionListener (this);
	settings.setActionCommand ("settings");
	settings.setPreferredSize (new Dimension (85, 30));
	settings.setBackground (buttonColour);
	settings.setForeground (buttonText);
	p3.add (settings);
	JButton rec = new JButton ("Record");
	rec.addActionListener (this);
	rec.setActionCommand ("rec");
	rec.setPreferredSize (new Dimension (75, 30));
	rec.setBackground (buttonColour);
	rec.setForeground (buttonText);
	p3.add (rec);

	card4.add (title);
	card4.add (p);
	card4.add (p1);
	card4.add (p2);
	card4.add (p3);
	p_card.add ("4", card4);
    }


    public void recordScreen ()
    { //the screen that displayes the record
	card5 = new Panel ();
	card5.setBackground (backgroundColour);
	Panel p = new Panel ();
	JLabel title = new JLabel ("Record");
	title.setFont (titleFont);
	title.setForeground (titleColour);
	title.setFont (titleFont);

	card5.add (title);
	JLabel d = new JLabel (createImageIcon ("o.png"));
	d.setPreferredSize (new Dimension (170, 100));
	p.add (d);
	JLabel v = new JLabel (createImageIcon ("x.png"));
	v.setPreferredSize (new Dimension (170, 100));
	p.add (v);

	Panel p1 = new Panel (new GridLayout (3, 2));
	p1.setBackground (backgroundColour);
	dp = new JLabel ("" + nm1);
	dp.setPreferredSize (new Dimension (170, 30));
	dp.setFont (promptFont);
	dp.setForeground (titleColour);
	p1.add (dp);
	vp = new JLabel ("" + nm2);
	vp.setPreferredSize (new Dimension (170, 30));
	vp.setFont (promptFont);
	vp.setForeground (titleColour);
	p1.add (vp);

	xwin = new JLabel ("Wins: "); //dp wins
	xwin.setPreferredSize (new Dimension (170, 30));
	xwin.setFont (promptFont);
	xwin.setForeground (titleColour);
	ywin = new JLabel ("Wins: "); //vamp wins
	ywin.setFont (promptFont);
	ywin.setForeground (titleColour);
	ywin.setPreferredSize (new Dimension (170, 30));
	p1.add (xwin);
	p1.add (ywin);
	xloss = new JLabel ("Losses: "); //dp loss
	xloss.setFont (promptFont);
	xloss.setForeground (titleColour);
	yloss = new JLabel ("Losses: "); //vamp loss
	yloss.setFont (promptFont);
	yloss.setForeground (titleColour);
	p1.add (xloss);
	p1.add (yloss);

	tie = new JLabel ("Ties: "); //Tie game
	tie.setFont (promptFont);
	tie.setForeground (titleColour);
	tie.setPreferredSize (new Dimension (170, 30));

	JButton entrance = new JButton ("Back to the game");
	entrance.setActionCommand ("4");
	entrance.addActionListener (this);
	entrance.setPreferredSize (new Dimension (300, 50));
	entrance.setBackground (buttonColour);
	entrance.setForeground (buttonText);

	JButton res = new JButton ("Reset Score");//reseting the score
	res.setActionCommand ("score");
	res.addActionListener (this);
	res.setPreferredSize (new Dimension (300, 50));
	res.setBackground (buttonColour);
	res.setForeground (buttonText);

	//showing the winner
	Panel p2 = new Panel ();
	up = new JLabel (createImageIcon ("thumbsup.jpg"));
	up.setPreferredSize (new Dimension (170, 100));
	down = new JLabel (createImageIcon ("thumbsdown.png"));
	down.setPreferredSize (new Dimension (170, 100));
	p2.add (up);
	p2.add (down);
	card5.add (p);
	card5.add (p1);
	card5.add (tie);
	card5.add (entrance);
	card5.add (res);
	card5.add (p2);
	p_card.add ("5", card5);
    }


    public void reset ()
    {//reseting everything except the level and the record

	board [0] [0] = 'b';
	board [0] [1] = 'b';
	board [0] [2] = 'b';
	board [1] [0] = 'b';
	board [1] [1] = 'b';
	board [1] [2] = 'b';
	board [2] [0] = 'b';
	board [2] [1] = 'b';
	board [2] [2] = 'b';
	a.setIcon (createImageIcon ("b.png"));
	b.setIcon (createImageIcon ("b.png"));
	c.setIcon (createImageIcon ("b.png"));
	d.setIcon (createImageIcon ("b.png"));
	ee.setIcon (createImageIcon ("b.png"));
	f.setIcon (createImageIcon ("b.png"));
	g.setIcon (createImageIcon ("b.png"));
	h.setIcon (createImageIcon ("b.png"));
	i.setIcon (createImageIcon ("b.png"));
	quest.setText ("Solve: " + s + " X " + t);
	flipTurn ();
    }


    public void updatescore ()
    {//updating the record
	nm1 = name.getText ();
	nm2 = name2.getText ();
	dp.setText (nm1);
	vp.setText (nm2);
	xwin.setText ("Wins: " + so);
	xloss.setText ("Losses: " + sx);
	ywin.setText ("Wins: " + sx);
	yloss.setText ("Losses: " + so);
	tie.setText ("Ties: " + st);
    }


    public void updatewinner ()
    {//updating the winner
	if (sx > so)
	{
	    down.setIcon (createImageIcon ("thumbsup.jpg"));
	    up.setIcon (createImageIcon ("thumbsdown.png"));
	}
	else if (so > sx)
	{
	    down.setIcon (createImageIcon ("thumbsdown.png"));
	    up.setIcon (createImageIcon ("thumbsup.jpg"));
	}
	else
	{
	    up.setIcon (createImageIcon ("thumbsup.jpg"));
	    down.setIcon (createImageIcon ("thumbsup.jpg"));
	}
    }


    public void actionPerformed (ActionEvent e)
    { //making the buttons function

	if (e.getActionCommand ().equals ("1"))
	{// button to show the first screen
	    cdLayout.show (p_card, "1");
	}
	else if (e.getActionCommand ().equals ("2"))
	{
	    cdLayout.show (p_card, "2");//going to instructions
	    reset ();
	}
	else if (e.getActionCommand ().equals ("3"))//going to settings
	{
	    cdLayout.show (p_card, "3");
	    reset ();
	}
	else if (e.getActionCommand ().equals ("gen"))//generating first turn
	{
	    generate ();
	}
	else if (e.getActionCommand ().equals ("4"))//going to the game
	{
	    cdLayout.show (p_card, "4");
	    level ();
	    reset ();
	    disable ();
	}
	else if (e.getActionCommand ().equals ("score"))
	{//reseting the record to 0
	    sx = 0;
	    so = 0;
	    st = 0;
	    updatescore ();
	}
	else if (e.getActionCommand ().equals ("rec"))
	{//going to the record screen
	    updatescore ();
	    updatewinner ();
	    cdLayout.show (p_card, "5");

	}
	//switching the levels from easy to hard
	else if (e.getActionCommand ().equals ("easy"))
	{
	    n = 5;
	}
	else if (e.getActionCommand ().equals ("med"))
	{
	    n = 10;
	}
	else if (e.getActionCommand ().equals ("hard"))
	{
	    n = 20;
	}

	//restarts the game for the next round but keeps the record
	else if (e.getActionCommand ().equals ("reset"))
	{
	    level ();
	    if (answer == s * t)
	    {
		enable ();
	    }
	    else
		flipTurn ();
	    reset ();

	}
	else if (e.getActionCommand ().equals ("settings"))
	{
	    cdLayout.show (p_card, "3");
	}
	else if (e.getActionCommand ().equals ("instruct"))
	{
	    cdLayout.show (p_card, "2");
	}

	//the user enters the answer and if it is wrong then switch turns
	else if (e.getActionCommand ().equals ("j"))
	{
	    answer = Integer.parseInt (ans.getText ());
	    if (answer == s * t)
	    {
		enable ();
	    }
	    else
		flipTurn ();
	}
	else
	{//the tictactoe buttons and updating them
	    if (e.getActionCommand ().equals ("a"))
		upDateSquare (0, 0, a);
	    else if (e.getActionCommand ().equals ("b"))
		upDateSquare (0, 1, b);
	    else if (e.getActionCommand ().equals ("c"))
		upDateSquare (0, 2, c);
	    else if (e.getActionCommand ().equals ("d"))
		upDateSquare (1, 0, d);
	    else if (e.getActionCommand ().equals ("ee"))
		upDateSquare (1, 1, ee);
	    else if (e.getActionCommand ().equals ("f"))
		upDateSquare (1, 2, f);
	    else if (e.getActionCommand ().equals ("g"))
		upDateSquare (2, 0, g);
	    else if (e.getActionCommand ().equals ("h"))
		upDateSquare (2, 1, h);
	    else if (e.getActionCommand ().equals ("i"))
		upDateSquare (2, 2, i);
	    win ();
	}
    }


    protected static ImageIcon createImageIcon (String path)
    {//incase an image is not found
	java.net.URL imgURL = TicTacToe.class.getResource (path);
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }
}
