// base JavaScript Core

Object.assign = Object.assign || function (target/*, ... sources*/) {
	if (!target) return target;
	var sources = arguments.slice(1);
	for (var i = 0, len = sources.length; i < len; i++) {
		for (var key in sources[i]) {
			if (sources[i].hasOwnProperty(key))
				target[key] = sources[i][key];
		}
	}
	return target;
}

