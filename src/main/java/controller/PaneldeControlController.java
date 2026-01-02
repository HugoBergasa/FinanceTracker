package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import javafx.event.ActionEvent;

public class PaneldeControlController {
    
    @FXML private Button btnDashboard;
    @FXML private Button btnTransactions;
    @FXML private Button btnStatistics;
    @FXML private Button btnBudgets;
    @FXML private Button btnAccounts;
    @FXML private Button btnSettings;
    @FXML private Button btnLogout;
    
    
    @FXML private Label greetingLabel;
    @FXML private Label dateLabel;
    @FXML private ComboBox<String> accountSelector;
    
    @FXML private Label incomeLabel;
    @FXML private Label expenseLabel;
    @FXML private Label balanceLabel;
    @FXML private Label accountBalanceLabel;
    
    @FXML private LineChart<String, Number> monthlyChart;
    @FXML private PieChart categoryChart;
    
    @FXML private Hyperlink viewAllLink;
    @FXML private Button fabButton;
    
    
     @FXML
    private void initialize() {
        configuracionHeader();
        configurarCombo();
        configurarGraficoMensual();
        configurarGraficoCategorias();
    }

    private void configuracionHeader() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM yyyy", 
                                                                   new Locale("es", "ES"));
        
        String dayName = today.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        String formattedDate = dayName.substring(0, 1).toUpperCase() + dayName.substring(1) + 
                              ", " + today.getDayOfMonth() + " de " +
                              today.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")) + 
                              " " + today.getYear();
        
        dateLabel.setText(formattedDate);
    }
    

    private void configurarCombo() {
        accountSelector.getItems().addAll(
            "Laboral Kutxa - Principal",
            "BBVA - Ahorros",
            "Santander - Efectivo"
        );
        accountSelector.getSelectionModel().selectFirst();
    }
    

    private void configurarGraficoMensual() {
        XYChart.Series<String, Number> incomeSeries = new XYChart.Series<>();
        incomeSeries.setName("Ingresos");
        incomeSeries.getData().add(new XYChart.Data<>("Mayo", 2300));
        incomeSeries.getData().add(new XYChart.Data<>("Junio", 2500));
        incomeSeries.getData().add(new XYChart.Data<>("Julio", 2400));
        incomeSeries.getData().add(new XYChart.Data<>("Agosto", 2600));
        incomeSeries.getData().add(new XYChart.Data<>("Septiembre", 2450));
        incomeSeries.getData().add(new XYChart.Data<>("Octubre", 2500));
        
        XYChart.Series<String, Number> expenseSeries = new XYChart.Series<>();
        expenseSeries.setName("Gastos");
        expenseSeries.getData().add(new XYChart.Data<>("Mayo", 1800));
        expenseSeries.getData().add(new XYChart.Data<>("Junio", 1600));
        expenseSeries.getData().add(new XYChart.Data<>("Julio", 1900));
        expenseSeries.getData().add(new XYChart.Data<>("Agosto", 1700));
        expenseSeries.getData().add(new XYChart.Data<>("Septiembre", 1550));
        expenseSeries.getData().add(new XYChart.Data<>("Octubre", 1450));
        
        monthlyChart.getData().addAll(incomeSeries, expenseSeries);
        
        monthlyChart.setCreateSymbols(true);
        monthlyChart.setAnimated(true);
    }
    

    private void configurarGraficoCategorias() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Alimentación", 450),
            new PieChart.Data("Transporte", 280),
            new PieChart.Data("Ocio", 180),
            new PieChart.Data("Vivienda", 300),
            new PieChart.Data("Servicios", 120),
            new PieChart.Data("Salud", 80),
            new PieChart.Data("Otros", 40)
        );
        
        categoryChart.setData(pieChartData);
        categoryChart.setStartAngle(90);
        categoryChart.setAnimated(true);
        
        pieChartData.forEach(data -> 
            data.nameProperty().bind(
                javafx.beans.binding.Bindings.concat(
                    data.getName(), " - ", 
                    String.format("%.0f€", data.getPieValue())
                )
            )
        );
    }
    

    private void anadirTransaccion() {
        System.out.println("Añadir nueva transacción");
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Nueva Transacción");
        alert.setHeaderText("Añadir transacción");
        alert.setContentText("Aquí se abriría el formulario para añadir una nueva transacción.");
        alert.showAndWait();
    }
    
    @FXML
    private void verPaneldeControl() {
        System.out.println("Mostrar Dashboard");
    }
    
    @FXML
    private void verTransacciones() {
        System.out.println("Mostrar Transacciones");
    }
    
    @FXML
    private void verEstadisticas() {
        System.out.println("Mostrar Estadísticas");
    }
    
    @FXML
    private void verPresupuestos() {
        System.out.println("Mostrar Presupuestos");
    }
    
    @FXML
    private void verCuentas() {
        System.out.println("Mostrar Cuentas");
    }
    
    @FXML
    private void verAjustes() {
        System.out.println("Mostrar Configuración");
    }
    
    @FXML
    private void cerrarSesion() {
        System.out.println("Cerrar sesión");
    }
    
    @FXML
    private void showAllTransactions() {
        System.out.println("Ver todas las transacciones");
    }

    @FXML
    private void handleAddTransaction(ActionEvent event) {
    }
}