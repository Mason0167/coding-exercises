namespace LabTest2Sample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Product[] inventory = new Product[5];
            int count = 0;

            while (true)
            {
                Console.WriteLine("1. Add Product");
                Console.WriteLine("2. List Products");
                Console.WriteLine("3. Apply Discount to All Products");
                Console.WriteLine("4. Exit");
                Console.Write("Choose an option: ");
                string choice = Console.ReadLine();


                switch (choice)
                {
                    case "1":
                        if (count < inventory.Length)
                        {
                            Console.Write("Enter product name: ");
                            string name = Console.ReadLine();
                            Console.Write("Enter product price: ");
                            double price = double.Parse(Console.ReadLine());

                            inventory[count] = new Product(name, price);
                            count++;
                        }
                        else
                        {
                            Console.WriteLine("Inventory is full.");
                        }
                        break;

                    case "2":
                        Console.WriteLine("Product List:");

                        for (int i = 0; i < count; i++)
                        {
                            inventory[i].DisplayProduct();
                        }
                        break;

                    case "3":
                        Console.Write("Enter discount percentage: ");
                        double percentage = double.Parse(Console.ReadLine());

                        for (int i = 0; i < count; i++)
                        {
                            inventory[i].ApplyDiscount(percentage);
                        }
                        break;

                    case "4":
                        return;

                    default:
                        Console.WriteLine("Invalid option. Try again.");
                        break;
                }
            }
        }
    }

    public class Product
    {
        private static int nextId = 1; // optional auto-increment
        private int productId;
        private string name;
        private double price;

        public Product(string name, double price)
        {
            this.productId = nextId++;
            this.name = name;
            this.price = price;
        }

        public void ApplyDiscount(double percentage)
        {
            double discount = price * (percentage / 100);
            price -= discount;
        }

        public void DisplayProduct()
        {
            Console.WriteLine($"ID: {productId}, Name: {name}, Price: {price:C}");
        }
    }
}
