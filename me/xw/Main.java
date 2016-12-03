package me.xw;

import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

class Printer
{
    private Scanner mScanner;
    private Controller mController;

    Printer( Controller con )
    {
        mScanner = new Scanner(System.in);
        mController = con;
    }

    private void printLine( String str )
    {
        System.out.println( str );
    }

    private boolean isNumber(String str )
    {
        return str.matches( "^[0-9]*$" );
    }

    void printMenu()
    {
        printLine("-----------------------------------------------------------");
        printLine("Average Fee Calcaulator: Please Input What You Want To Do");
        printLine("-----------------------------------------------------------");
        printLine("1.Add the player info");
        printLine("2.Add money spent info");
        printLine("3.Calculate the final result");

        dealWithInput( mScanner.next() );
    }

    private void dealWithInput( String inputNum )
    {
        int command = 0;

        if ( isNumber( inputNum ) )
        { command = Integer.parseInt( inputNum ); }

        switch(command)
        {
            case 1:     command1();                     break;
            case 2:     command2();                     break;
            case 3:     command3();                     break;
            default:
            {
                printLine("----------------------------------------");
                printLine("             Invalid input              ");
                printLine("----------------------------------------");
                printMenu();                            break;
            }
        }
    }

    private void command1()
    {
        printLine("----------------------------------------");
        printLine("Please do as following commands");
        printLine("----------------------------------------");

        String s = "";
        while( true )
        {
            printLine("Input next person name, 0 to the main menu");

            s = mScanner.next();

            if( s.equals("0") ) { break; }

            mController.addPlayer( s );
        }

        printMenu();
    }

    private void command2()
    {
        printLine("----------------------------------------");
        printLine("Please do as following commands");
        printLine("----------------------------------------");
        printLine( "Input who pay the money( one person )" );

        ArrayList<String> payPlayers = new ArrayList<String>();
        ArrayList<Float> payNums = new ArrayList<Float>();
        String curPayer = mScanner.next();
        payPlayers.add( curPayer );

        printLine( "How much he/she paid" );
        payNums.add( mScanner.nextFloat() );

        String s = "";
        while( true )
        {
            printLine( "Input who else pay the money( one person ), 0 to main menu" );

            s = mScanner.next();

            if( s.equals("0") ) { break; }

            else { payPlayers.add( s ); }

            printLine( "How much he/she paid" );

            payNums.add( mScanner.nextFloat() );
        }

        ArrayList<String> sharedPlayers = new ArrayList<String>();

        while( true )
        {
            printLine( "Who will share this payment( one person each time )" );

            s = mScanner.next();


            break;
        }
        printMenu();
    }


    private void command3()
    {
        printLine("----------------------------------------");
        printLine("Please do as following commands");
        printLine("----------------------------------------");

        printMenu();
    }
}

class Controller
{
    private Printer mPrint;
    private InfoStorage mInfoStorage;
    Controller()
    {
        mPrint = new Printer( this );
        mInfoStorage = new InfoStorage();
    }

    void printMenu()
    {
        mPrint.printMenu();
    }

    void addPlayer( String name )
    {
        mInfoStorage.addPlayer( name );
    }

    void addPayInfo( )
    {

    }
}

class InfoStorage
{
    private ArrayList<Player> mPlayers ;
    InfoStorage()
    {
        mPlayers = new ArrayList<Player>();
    }

    void addPlayer( String name )
    {
        mPlayers.add( new Player( name ) );
    }
}

class Player
{
    private String mName;
    private Map<String,Integer> moneySpent;

    Player( String name )
    {
        mName = name;
    }
}


public class Main
{
    public static void main(String[] args) {
        new Controller().printMenu();
    }
}
