//Chipo Sekabanja
//Project 3
//





using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Proj3
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private const double GenPubPrice = 80.0;
        private const double AlumniDisc = 0.10;
        private const double FacultyAndStaffDisc = 0.15;
        private const double MilitaryDisc = 0.20;
        private const double StudentDisc = 0.50;
        private const double ParkingPass = 25.0;
        public MainWindow()
        {
            InitializeComponent();
        }

        private void RadioButton_Checked(object sender, RoutedEventArgs e)
        {

        }

        private void RadioButton_Checked_1(object sender, RoutedEventArgs e)
        {

        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if (!int.TryParse(uxNumberOfTickets.Text, out int numberOfTickets) || numberOfTickets <= 0)
            {
               MessageBox.Show("Invalid number of tickets. Please enter a valid positive integer.");
               return;
            }

            double totalPrice = 0.0;

            if (uxStudentSelectRB.IsChecked == true)
                totalPrice += GenPubPrice * (1 - StudentDisc);
            if (uxAlumniSelectRB.IsChecked == true)
                totalPrice += GenPubPrice * (1 - AlumniDisc);
            if (uxMilitarySelectRB.IsChecked == true)
                totalPrice += GenPubPrice * (1 - MilitaryDisc);
            if (uxFacultyStaffSelectRB.IsChecked == true)
                totalPrice += GenPubPrice * (1 - FacultyAndStaffDisc);
            if (uxGeneralPublicSelectRB.IsChecked == true)
                totalPrice += GenPubPrice;

            if (uxParkingCheckBox.IsChecked == true)
                totalPrice += ParkingPass;


            totalPrice*= numberOfTickets;

            MessageBox.Show($"Total Cost for {numberOfTickets} Ticket(s): ${totalPrice:F2}");



        }

        private void CheckBox_Checked(object sender, RoutedEventArgs e)
        {

        }

        private void RadioButton_Checked_2(object sender, RoutedEventArgs e)
        {

        }

        private void RadioButton_Checked_3(object sender, RoutedEventArgs e)
        {

        }

        private void TextBox_TextChanged(object sender, TextChangedEventArgs e)
        {

        }

        private void RadioButton_Checked_4(object sender, RoutedEventArgs e)
        {

        }

        private void RadioButton_Checked_5(object sender, RoutedEventArgs e)
        {

        }

        private void RadioButton_Checked_6(object sender, RoutedEventArgs e)
        {

        }
    }
}
