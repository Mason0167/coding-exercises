namespace LabTest2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Car defaultConstructor = new Car();
            Car Constructor1 = new Car("Model 1", "Toyota", 1232.58);
            double[] arrayCar = [123.55, 987.55];
            Car Constructor2 = new Car("Model 2", "Honda", 55443.77, arrayCar);


            Car[] garage = new Car[3];
            garage[0] = defaultConstructor;
            garage[1] = Constructor1;
            garage[2] = Constructor2;


            foreach (Car c in garage)
            {
                Console.WriteLine(c);
            }


        }


    }

    class Car
    {
        private static int carId = 1;
        private int id;
        private string model;
        private string manufacturer;
        private double price;
        private double[] fuelEfficiencies;

        public int ID {get;}
        public string Model { get; set; }
        public string Manufacturer { get; set; }
        public double Price { get; set; }
        public double[] FuelEfficiencies { get; set; }

        public Car()
        {
            ID = carId;
            Model = "Uknown";
            Manufacturer = "Unknown";
            Price = 0.0;
            FuelEfficiencies = fuelEfficiencies;
        }

        public Car(string model, string manufacturer, double price)
        {
            ID = ++carId;
            Model = model;
            Manufacturer = manufacturer;
            Price = price;

        }
        
        public Car(string model, string manufacturer, double price, double[] fuelEfficienciesue)
        {
            ID = ++carId;
            Model = model;
            Manufacturer = manufacturer;
            Price = price;
            FuelEfficiencies = fuelEfficienciesue;
        }

        public double GetAverageFuelEfficiency()
        {
            if(FuelEfficiencies.Length == 0)
            {
                return 0.0;
            }
            return 0.0;
        }


        
        public override string ToString()
        {
            if (FuelEfficiencies == null)
            {
                return $"Car's ID: {ID}, Model: {Model}, Manufacturer: {Manufacturer}, Price: {Price}";
            }
            return $"Car's ID: {ID}, Model: {Model}, Manufacturer: {Manufacturer}, Price: {Price}, Fuel Efficiencies: {string.Join(',', FuelEfficiencies)}";
        }
        
    }
}
