
var HelloWorldLayer = cc.Layer.extend({
    sprite:null,
    angle: 0,
    ctor:function () {
        this._super();

        var mainScene = ccs.load(res.json.Main);
        this.addChild(mainScene.node);

        var layer = this.layer = new cc.LayerGradient(cc.color(255,0,0,255), cc.color(0,255,255,255),cc.p(1,0));
        // mainScene.node.addChild(layer);
        // this.scheduleUpdate();
        cc.log(Math.cos(60/180 * Math.PI));
        for(var k in mainScene.node) {
            cc.log(k, mainScene.node[k]);
        }
        cc.log(typeof mainScene.node);
        cc.log(mainScene.node.toString());
        // cc.log(mainScene.getCustomProperty());
        var comp = mainScene.node.getComponent("ComExtensionData");
        var data = comp.getCustomProperty();
        data = JSON.parse(data);
        cc.log(data.type, data.value);

        var comp1 = mainScene.node.getChildByName("layer1").getComponent("ComExtensionData");
        data = comp1.getCustomProperty();
        data = JSON.parse(data);
        cc.log(data.type, data.value);

        // cc.log(ccui.helper.seekNodeByTag);
        cc.log(_.each);
        // cc.log(Object.observe);
        cc.log(Symbol("Hello"));

        // var param = mainScene.node.getChildByName("button2").getLayoutParameter(ccui.LayoutParameter.RELATIVE);
        // cc.log(param);
        // for(var key in param) {
        //     cc.log(key, param[key]);
        // }

        return true;
    },
    update: function() {
        var vec = this.layer.getVector();
        this.angle++;
        this.angle %= 360;
        var ang = this.angle / 180 * Math.PI;
        this.layer.setVector(cc.p(Math.cos(ang), Math.sin(ang) ) );
    }
});

var HelloWorldScene = cc.Scene.extend({
    onEnter:function () {
        this._super();
        var layer = new HelloWorldLayer();
        this.addChild(layer);
    }
});

