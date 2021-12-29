module GestionDeStock {
	requires javafx.controls;
	requires java.sql;
	requires transitive javafx.graphics;
	requires javafx.fxml;
	requires transitive javafx.base;
	requires java.xml;
	requires itextpdf;
	exports Main to javafx.graphics;
	opens controllers to javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
}
