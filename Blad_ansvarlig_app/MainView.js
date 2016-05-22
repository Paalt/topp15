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


//Test Grupper
function Gruppe(id, navn, medlemmer, beskrivelse)
{
  this.id = id;
	this.navn = navn;
	this.medlemmer = medlemmer;
  this.beskrivelse = beskrivelse;
}

var grupper = [
	new Gruppe (0,"Gruppe 1", 14, "Dette er en test beskrivelse"),
	new Gruppe (1,"Kiwis gruppe", 25, "Kiwis gruppe"),
	new Gruppe (2,"Gruppe 3", 50,"N/A"),
	new Gruppe (3,"Remas gruppe", 1,"REMA!!!!"),
	new Gruppe (4,"Coops gruppe", 8,"Coop > rema"),
	new Gruppe (5,"Østlands gruppen", 13,"For alle de butikkene på østlandet"),
	new Gruppe (6,"Gruppe 0111", 11,"The binary group"),
	new Gruppe (7,"Gruppe 8", 36,"")
]
var id = Observable('HEI');
getId = function(e)
{
  id.value = e.data.body;
  module.exports = {
  	id: id.value
  }
  console.log(id.value)
}

// Code for getting RSS
var data = Observable();
fetch('http://az664292.vo.msecnd.net/files/P6FteBeij9A7jTXL-edgenavresponse.json').then(function(response) { return response.json(); }).then(function(responseObject) { data.value = responseObject; });
module.exports = {
    dataSource: data
};

module.exports = {
  id : id,
	grupper: grupper,
  getId : getId,
  data : data
}
