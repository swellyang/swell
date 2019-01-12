/**
 * 系统数据管理
 */
var SystemData = {
	roles : [ {
		code : "A00001",
		name : "派出所考核",
		node : "f1",// 节点
		menus : [ {
			name : "案件申报",
			url : "/platform/case/report/pcs",
			icon : "ios-paper"
		}, {
			name : "案件标签",
			url : "/platform/case/label/page",
			icon : "md-pricetags"
		}, {
			name : "处理结果",
			url : "/platform/case/result/page",
			icon : "md-pricetags"
		}, {
			name : "案件质量",
			url : "/platform/case/quality/page",
			icon : "ios-analytics"
		}, {
			name : "案件规模",
			url : "/platform/case/scale/page",
			icon : "ios-football-outline"
		}, {
			name : "打击数据-逮捕",
			url : "/platform/dj/db",
			icon : "ios-barcode-outline"
		}, {
			name : "打击数据-刑拘",
			url : "/platform/dj/xj",
			icon : "ios-barcode-outline"
		}, {
			name : "打击数据-公诉",
			url : "/platform/dj/gs",
			icon : "ios-barcode-outline"
		}, {
			name : "人口数据",
			url : "/platform/rk/index",
			icon : "ios-barcode-outline"
		} ]
	}, {
		code : "B00001",
		name : "拘留所",
		node : "f2",
		menus : [ {
			name : "案件审核",
			url : "/platform/case/report/ksjls",
			icon : "ios-paper"
		} ]
	}, {
		code : "B00002",
		name : "看守所",
		node : "f2",
		menus : [ {
			name : "案件审核",
			url : "/platform/case/report/ksjls",
			icon : "ios-paper"
		} ]
	}, {
		code : "C00001",
		name : "治安支队",
		node : "f3",
		menus : [ {
			name : "案件审核",
			url : "/platform/case/report/ywzd",
			icon : "ios-paper"
		} ]
	}, {
		code : "C00002",
		name : "刑侦支队",
		node : "f3",
		menus : [ {
			name : "案件审核",
			url : "/platform/case/report/ywzd",
			icon : "ios-paper"
		} ]
	}, {
		code : "D00002",
		name : "分局执法",
		node : "f4",
		menus : [ {
			name : "案件确认",
			url : "/platform/case/report/fj",
			icon : "ios-paper"
		} ]
	} ],
	// 案件规模数据
	caseScaleData : function() {
		return [ {
			key : '0001',
			label : '团伙性案件'
		}, {
			key : '0002',
			label : '系列性案件'
		}, {
			key : '0003',
			label : '流传性案件(跨省市)'
		}, {
			key : '0004',
			label : '涉黑涉恶案件'
		}, {
			key : '0005',
			label : '重大复杂敏感案件（市局领导批示）'
		}, {
			key : '0006',
			label : '重大复杂敏感案件（分局领导批示）'
		}, {
			key : '0007',
			label : '12小时快侦快破命案,两抢案件'
		}, {
			key : '0008',
			label : '24小时快侦快破命案,两抢案件'
		} ];
	},
	ajxz : [ "01", "02" ],
	ywzd : [ "C00001", "C00002" ],
	jlkss : [ "B00001", "B00002" ],
	rolecode : {
		ROLE_PCS : "A00001",
		ROLE_ZAZD : "C00001",
		ROLE_XZZD : "C00002",
		ROLE_JLS : "B00001",
		ROLE_KSS : "B00002",
		ROLE_FJFZ : "D00002",
	}
};
