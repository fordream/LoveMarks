// base for Cocos2d-js Engine

(function() { // begin

var helper = {
	/**
	 * Finds a node whose tag equals to param tag from root node.
	 * @param {ccui.Node} root
	 * @param {number} tag
	 * @returns {ccui.Node}
	 */
	seekNodeByTag: function (root, tag) {
	    if (!root)
	        return null;
	    if (root.getTag() === tag)
	        return root;

	    var arrayRootChildren = root.getChildren();
	    var length = arrayRootChildren.length;
	    for (var i = 0; i < length; i++) {
	        var child = arrayRootChildren[i];
	        var res = ccui.helper.seekNodeByTag(child, tag);
	        if (res !== null)
	            return res;
	    }
	    return null;
	},

	/**
	 * Finds a node whose name equals to param name from root node.
	 * @param {ccui.Node} root
	 * @param {String} name
	 * @returns {ccui.Node}
	 */
	seekNodeByName: function (root, name) {
	    if (!root)
	        return null;
	    if (root.getName() === name)
	        return root;
	    var arrayRootChildren = root.getChildren();
	    var length = arrayRootChildren.length;
	    for (var i = 0; i < length; i++) {
	        var child = arrayRootChildren[i];
	        var res = ccui.helper.seekNodeByName(child, name);
	        if (res !== null)
	            return res;
	    }
	    return null;
	}
}

cc.extend(ccui.helper, helper);

}()); // end