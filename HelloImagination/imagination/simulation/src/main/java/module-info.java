module com.sixmops.simulation {
	requires java.base;
	requires transitive javafx.base;
	requires transitive javafx.controls;
	requires transitive javafx.graphics;
	requires com.sixmops.component.bits;
	exports com.sixmops.simulation;
}