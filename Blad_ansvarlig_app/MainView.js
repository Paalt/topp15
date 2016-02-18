var Observable = require("FuseJS/Observable");

function TaskItem(text, timeSlot, i, image){
	this.text = Observable(text);
	this.timeSlot = Observable(timeSlot);
	this.delay = Observable(i * 0.05);
	this.image = image;
}

var items = Observable(
	new TaskItem("New subpage for Janet", "8 - 10am", 1, "home1"),
	new TaskItem("Catch up with Tom", "11 - 12am Hangouts", 2, "home2"),
	new TaskItem("Lunch with Diane", "12am Restaurant", 3, "home3")
);


module.exports = {
	items: items
};
