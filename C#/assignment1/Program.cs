using System.Diagnostics.CodeAnalysis;
using System.Transactions;

namespace assignment1
{
    internal class Program
    {
        public static string MainMenu()
        {
            Console.WriteLine("Please choose an option, type the number from 1 to 4");
            Console.WriteLine("Option 1: Display Information");
            Console.WriteLine("Option 2: Date and Time Operations");
            Console.WriteLine("Option 3: Text Operations");
            Console.WriteLine("Option 4: Exit");
            Console.Write("Your option is: ");
            return Console.ReadLine();
        }

        public static string DTMenu()
        {
            Console.Clear();
            Console.WriteLine("This is Date and Time Operations");
            Console.WriteLine("Option 1: Display Current Date and Time");
            Console.WriteLine("Option 2: Add Days to Current Date");
            Console.WriteLine("Option 3: Calculate Age from Birthdate");
            Console.WriteLine("Option 4: Return to Main Menu");
            Console.Write("Your option is: ");
            return Console.ReadLine(); 
        }

        public static string textMenu()
        {
            Console.Clear();
            Console.WriteLine("This is Text Operations, please choose a number");
            Console.WriteLine("Option 1: Reverse Text");
            Console.WriteLine("Option 2: Convert to Uppercase");
            Console.WriteLine("Option 3: Convert to Lowercase");
            Console.WriteLine("Option 4: Return to Main Menu");
            Console.Write("Your option is: ");
            return Console.ReadLine();
        }

        static string info()
        {
            Console.Clear();
            Console.WriteLine( "Information");
            Console.WriteLine("Name: Cheng-Yeh Tsai");
            Console.WriteLine("Student ID: 101539796");
            Console.WriteLine("Program: T186");
            Console.WriteLine("Press any key to go back to Main Menu");
            return Console.ReadLine();
        }

        

        static void Main(string[] args) // Thr program starts from here
        {
            while (true)
            {
                var choice = MainMenu();
                if (choice == "1")
                {
                    info(); // Go to info section and display personal information
                }
               else if (choice == "2")
                {
                    DTChoice(); // Go to date and time operation menu section
                }
                else if (choice == "3")
                {
                    textChoice(); // Go to text operation menu section
                }
                else if (choice == "4")
                {
                    break; // exit the program
                }
                else 
                {
                    Console.WriteLine("Bad input try again"); // oupput error until user input the right format
                }
            }
        }

        private static void textChoice()
        {
            try
            {
                while (true)
                {
                    var choice = textMenu();
                    if (choice == "1")
                    {
                        Console.WriteLine("Please enter some text: ");
                        string input = Console.ReadLine(); // Store the text into input
                        string reversedString = String.Empty; // Create a new string

                        for (int i = input.Length - 1; i >= 0; i--) // use for loop to put input into new string word by word
                        {
                            reversedString += input[i];
                        }
                        Console.WriteLine(reversedString); // Display the result
                        Console.WriteLine();
                        Console.WriteLine("Press any key to go back to Main Menu");
                        Console.ReadLine();
                        return;
                    }
                    else if (choice == "2")
                    {
                        Console.WriteLine("Please enter some text: ");
                        string input = Console.ReadLine();
                        Console.WriteLine(input.ToUpper()); // Use ToUpper to convert the tet to upper case and display the result
                        Console.WriteLine();
                        Console.WriteLine("Press any key to go back to Main Menu");
                        Console.ReadLine();
                        return;
                    }
                    else if (choice == "3")
                    {
                        Console.WriteLine("Please enter some text: ");
                        string input = Console.ReadLine();
                        Console.WriteLine(input.ToLower()); // Use ToLower to convert the tet to lower case and display the result
                        Console.WriteLine();
                        Console.WriteLine("Press any key to go back to Main Menu");
                        Console.ReadLine();
                        return;
                    }
                    else if (choice == "4")
                    {
                        Console.Clear();
                        return; // Goback to main menu
                    }
                    else Console.WriteLine("Bad input try again");
                }
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }


        private static void DTChoice()
        {
            try
            {
                while (true)
                {
                    var choice = DTMenu();
                    if (choice == "1")
                    {
                        Console.Clear();
                        Console.WriteLine(DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss")); // Use DateTime.Now.ToString to display the current date and time
                        Console.WriteLine();
                        Console.WriteLine("Press any key to go back to Main Menu");
                        Console.ReadLine();
                        return;
                    }
                    else if (choice == "2")
                    {
                        Console.Clear();
                        Console.WriteLine("How many days do you want to add in current date");
                        var addedDateTime = DateTime.Now.AddDays(Convert.ToDouble(Console.ReadLine())); // Use DateTime.Now.AddDays to add day into current date and use Convert.ToDouble to convert a string to double
                        Console.WriteLine(addedDateTime);
                        Console.WriteLine();
                        Console.WriteLine("Press any key to go back to Main Menu");
                        Console.ReadLine();
                        return;
                    }
                    else if (choice == "3")
                    {
                        Console.Clear();
                        DateOnly bday = new DateOnly(2001, 6, 7); // 
                        DateOnly today = DateOnly.FromDateTime(DateTime.Now); // I only want date so I use DateOnly
                        int age = today.Year - bday.Year; // extract year from both variables and calculate the age
                        Console.WriteLine("You are " + age + " yeas old");
                        Console.WriteLine();
                        Console.WriteLine("Press any key to go back to Main Menu");
                        Console.ReadLine();
                        return;
                    }
                    else if (choice == "4")
                    {
                        Console.Clear();
                        return;
                    }
                    else Console.WriteLine("Bad input try again");
                }
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
    }
}
