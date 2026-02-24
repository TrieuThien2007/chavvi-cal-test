package com.example;

import java.util.*;

/*
 * chavvi calc calculator
 */
public class ChavviCalcExampleApp {
  private static Float valueA = 0.0f;
  private static Float valueB = 0.0f;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Character command = '_';

    // loop until user quits
    while (command != 'q') {
      printMenu();
      System.out.print("Enter a command: ");
      command = menuGetCommand(scan);

      executeCommand(scan, command);
    }

    scan.close();
  }

  //
  // menu functions
  //
  private static void printMenuLine() {
    System.out.println(
        "----------------------------------------------------------");
  }

  private static void printMenuCommand(Character command, String desc) {
    System.out.printf("%s\t%s\n", command, desc);
  }

  // prints the menu
  public static void printMenu() {
    printMenuLine();
    System.out.println("ChavviCalc");
    printMenuLine();
    System.out.printf("A = %.3f          B = %.3f\n", valueA, valueB);
    printMenuLine();
    printMenuCommand('a', "Enter a value for A");
    printMenuCommand('b', "Enter a value for B");
    printMenuCommand('+', "Add");
    printMenuCommand('-', "Subtract");
    printMenuCommand('*', "Multiply");
    printMenuCommand('/', "Divide");
    printMenuCommand('c', "Clear");
    printMenuCommand('q', "Quit");

    printMenuLine();
  }

  private static Boolean doSetA(Scanner scan) {
  System.out.print("Enter value for A: ");
  Float tmp = readFloat(scan);
  if (tmp == null) return false;
  valueA = tmp;
  return true;
}
  private static Boolean doSetB(Scanner scan) {
  System.out.print("Enter value for B: ");
  Float tmp = readFloat(scan);
  if (tmp == null) return false;
  valueB = tmp;
  return true;
}
private static Boolean doAdd() {
  valueA = valueA + valueB;               
  System.out.printf("Result: %.3f\n", valueA);
  return true;
}
private static Boolean doSubtract() {
  valueA = valueA - valueB;                
  System.out.printf("Result: %.3f\n", valueA);
  return true;
}
private static Boolean doMultiply() {
  valueA = valueA * valueB;              
  System.out.printf("Result: %.3f\n", valueA);
  return true;
}

  // get first character from input
  private static Character menuGetCommand(Scanner scan) {
    Character command = '_';

    String rawInput = scan.nextLine();

    if (rawInput.length() > 0) {
      rawInput = rawInput.toLowerCase();
      command = rawInput.charAt(0);
    }

    return command;
  }
  //read float value from user input
  private static Float readFloat(Scanner scan) {
  try {
    return Float.parseFloat(scan.nextLine().trim());
  } catch (Exception e) {
    System.out.println("ERROR: Invalid number");
    return null;
  }
}


  // calculator functions
  private static Boolean executeCommand(Scanner scan, Character command) {
    Boolean success = true;

    switch (command) {
      case 'q':
        System.out.println("Thank you for using Chavvi Calc");
        break;
      default:
        System.out.println("ERROR: Unknown commmand");
        success = false;

      case 'a':
       success = doSetA(scan);
        break;

      case 'b':
        success = doSetB(scan);
        break;

      case '+':
       success = doAdd();
        break;
      case '-':
        success = doSubtract();
        break;

      case '*':
        success = doMultiply();
        break;

      case '/':
        if (valueB == 0) {
          System.out.println("ERROR: Division by zero");
          success = false;
        } else {
          valueA = valueA / valueB;
          System.out.printf("Result: %.3f\n", valueA / valueB);
        }
        break;

      case 'c':
        valueA = 0.0f;
        valueB = 0.0f;
        break;
    }

    return success;
  }
}
