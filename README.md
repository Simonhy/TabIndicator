# PagerTopTabIndicatorAdd
对上一个自定义tab控件修改,添加动画效果,仿ios今日头条的切换动画
# 使用方式:
 Step 1
 Add it in your root build.gradle at the end of repositories:
## 
    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 Step 2. Add the dependency
## 
	dependencies {
	         compile 'com.github.Simonhy:PagerTopTabIndicatorAdd:Addv1.1'
	}
## 代码中使用 与上一篇的PagerTopTabIndicator一致,不做累述
   只是添加了动画 修改了部分源码
### // 设置选中Tab文字的颜色
        tabs.setSelectedTextColor(Color.RED);
        //设置Tab文字的左右间距,传入的是dp
        tabs.setTabPaddingLeftRight(24);

        //设置点击每个Tab时的背景色
        tabs.setTabBackground(R.drawable.background_tab);

        //是否支持动画渐变(颜色渐变和文字大小渐变)
        tabs.setFadeEnabled(false);
        // 设置最大缩放,是正常状态的0.3倍
        tabs.setZoomMax(0.3F);
        //这是当点击tab时内容区域Viewpager是否是左右滑动,默认是true
        tabs.setSmoothScrollWhenClickTab(false);
   ## 可以设置单击和双击的监听
       tabs.setOnPagerTitleItemClickListener(new PagerTabIndicator.OnPagerTitleItemClickListener() {
            @Override
            public void onSingleClickItem(int position) {
                Toast.makeText(MainActivity.this, "单击", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDoubleClickItem(int position) {
                Toast.makeText(MainActivity.this, "双击", Toast.LENGTH_SHORT).show();
            }
        });
## maven使用
     Step 1. Add the JitPack repository to your build file
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>Copy
    Step 2. Add the dependency
	<dependency>
	    <groupId>com.github.Simonhy</groupId>
	    <artifactId>PagerTopTabIndicatorAdd</artifactId>
	    <version>Addv1.1</version>
	</dependency>
