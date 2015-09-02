
var res = {};
var g_resources = [];

(function() { // begin

var png = res.png = {
};

var json = res.json = {
	Main : "res/splash/main.json",
	"Layer":"res/splash/layer.json",
}

for (var i in png) {
    g_resources.push(png[i]);
}
for (var i in json) {
	g_resources.push(json[i]);
}

}()); // end