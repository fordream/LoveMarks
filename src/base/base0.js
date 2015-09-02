// base JavaScript Core

Object.assign = Object.assign || function (target/*, ... sources*/) {
	if (!target) return target;
	var arg = arguments.slice(1);
	for (var i = 0, len = arg.length; i < len; i++) {
		for (var key in arg[i]) {
			if (arg[i].hasOwnProperty(key))
				target[key] = arg[i][key];
		}
	}
	return target;
}

