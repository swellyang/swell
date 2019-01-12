//项目名称
var __webRoot = "/swell";

// 常量：是否,
var YesOrNo = {
    yes: 1,
    no: 0
};
// 常量：字典类型
var DictType = {
    dict: 1,
    group: 2
};
// 常量：字典代码
var DictCodes = {
    gender: "gender"
};


/**
 * ----------------------------------------------------------------------------------------------
 * ------------------------ 扩展jQuery的Ajax方法
 * -------------------------------------------------
 * ----------------------------------------------------------------------------------------------
 */
$.extend({

    getContentHeight: function () {
        var winHeight = $(window).innerHeight();// 窗口高度
        var headerHeight = 64;// 顶部高度
        var paddingTop = 24;
        var fotterHeight = 30;// 底部padding
        var contentHeight = winHeight - headerHeight - paddingTop - fotterHeight;
        return contentHeight;
    },

    // 重置父页面IFrame高度
    resetParentFrameHeight: function () {
        var offsetHeight = 0;
        if (document.documentElement && document.documentElement.offsetHeight) {
            offsetHeight = document.documentElement.offsetHeight;
        } else if (document.body) {
            offsetHeight = document.body.offsetHeight;
        }
        console.log(offsetHeight);

        $(window.parent.document).find("#contentFrame").css({
            "min-height": offsetHeight + "px"
        });

        return offsetHeight;
    },

    validateMobile: function (mobile) {
        var phoneReg = /(^1[3|4|5|7|8|9]\d{9}$)|(^09\d{8}$)/;
        if (mobile && phoneReg.test(mobile)) {
            return true;
        }
        return false;
    }
    ,
    getParam: function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return r[2];
        return null;
    }
    ,
    computeAge: function (birthday) {
        var age;
        if (!birthday) {
            return "";
        }
        var ymdNow = new Date().pattern("yyyy-MM-dd");
        var y = parseInt(ymdNow.split("-")[0]) - parseInt(birthday.split("-")[0]);
        var m = parseInt(ymdNow.split("-")[1]) - parseInt(birthday.split("-")[1]);
        var d = parseInt(ymdNow.split("-")[2]) - parseInt(birthday.split("-")[2]);
        age = y - 1;
        if (m >= 0 && d >= 0) {
            age++;
        }
        return age;
    }
    ,
    ajaxGet: function (url, data, callback) {
        $.ajax({
            url: url,
            type: "get",
            data: data,
            dataType: "json",
            headers: {}, // 保留headers，后期可能会用到headers传递token
            xhrFields: {
                // 设置为true，避免跨域清空下漏传session
                withCredentials: true
            },
            timeout: 10000,
            success: function (rs) {
                if (callback) {
                    callback(rs);
                }
            },
            error: function (xhr, textStatus, errorThrown) {
                console.log("ajax get error");
                console.log(xhr);
            }
        });
    }
    ,
    ajaxPost: function (url, data, callback) {
        $.ajax({
            url: url,
            type: "post",
            data: data,
            dataType: "json",
            headers: {},
            xhrFields: {
                // 设置为true，避免跨域情况下漏传session
                withCredentials: true
            },
            timeout: 10000,
            success: function (rs) {
                if (callback) {
                    callback(rs);
                }
            },
            error: function (xhr, textStatus, errorThrown) {
                console.log("ajax post error");
                console.log(xhr);
            }
        });
    }
    ,
    ajaxPostBody: function (url, data, callback) {
        $.ajax({
            url: url,
            type: "post",
            data: data,
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            headers: {},
            xhrFields: {
                // 设置为true，避免跨域清空下漏传session
                withCredentials: true
            },
            timeout: 10000,
            success: function (rs) {
                if (callback) {
                    callback(rs);
                }
            },
            error: function (xhr, textStatus, errorThrown) {
                console.log("ajax post error");
                console.log(xhr);
            }
        });
    }
})
;

/**
 * ----------------------------------------------------------------------------------------------
 * ------------------------ 时间格式化
 * -------------------------------------------------
 * ----------------------------------------------------------------------------------------------
 */
Date.prototype.pattern = function (fmt) {
    if (!fmt) {
        fmt = "yyyy-MM-dd HH:mm:ss";
        // fmt = "yyyy-MM-dd";
    }
    var o = {
        "M+": this.getMonth() + 1, // 月份
        "d+": this.getDate(), // 日
        "h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, // 小时
        "H+": this.getHours(), // 小时
        "m+": this.getMinutes(), // 分
        "s+": this.getSeconds(), // 秒
        "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
        S: this.getMilliseconds()
        // 毫秒
    };
    var week = {
        "0": "/u65e5",
        "1": "/u4e00",
        "2": "/u4e8c",
        "3": "/u4e09",
        "4": "/u56db",
        "5": "/u4e94",
        "6": "/u516d"
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(
            RegExp.$1,
            (this.getFullYear() + "").substr(4 - RegExp.$1.length)
        );
    }
    if (/(E+)/.test(fmt)) {
        fmt = fmt.replace(
            RegExp.$1,
            (RegExp.$1.length > 1
                ? RegExp.$1.length > 2
                    ? "/u661f/u671f"
                    : "/u5468"
                : "") + week[this.getDay() + ""]
        );
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(
                RegExp.$1,
                RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length)
            );
        }
    }
    return fmt;
};


