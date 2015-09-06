// base JavaScript Core

Object.assign = Object.assign || function (target/*, ... sources*/) {
	if (!target) return target;
	var sources = arguments.slice(1);
	for (var i = 0, len = sources.length; i < len; i++) {
		var src = sources[i];
		for (var key in src) {
			if (src.hasOwnProperty(key))
				target[key] = src[key];
		}
	}
	return target;
}

