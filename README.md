# BezierCurveShoppingCart
一个基于贝塞尔曲线二阶 + 属性动画实现添加商品到购物车动画效果.

#### 思路
* 确定动画起终点
* 在起终点之间使用二次贝塞尔曲线填充起终点之间点的轨迹
* 设置属性动画，ValueAnimator插值器，获取中间点的坐标
* 将执行动画控件的x、y坐标设为上面得到的中间点坐标
* 开启属性动画
* 当动画结束时的操作


### Author
* QQ:872721111
* Email:leibing1989@126.com
* Github:[leibing@github](https://github.com/leibing8912)
* 简书:[leibing@jianshu](http://www.jianshu.com/users/e3057e46c9e9/latest_articles)
* 掘金:[leibing@juejin](http://gold.xitu.io/user/579eb39ea633bd006005ec92)

### License
Copyright 2016 leibing

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
