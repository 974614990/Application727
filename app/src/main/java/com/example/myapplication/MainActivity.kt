package com.example.myapplication

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

/**
 * activity用于管理界面的生命周期 和 交互
 * 具体的界面需要自己配置 res -> layout -> 配置文件.xml
 * 通过setContentView 来关联layout布局文件和Java/kotlin代码
 * 所有的资源文件都会有一个id和他对应
 * 如果要访问就通过 R.layout.activity_main 通过R来关联 R.mitemap.logo
 */
class MainActivity : AppCompatActivity() ,View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //监听按钮被点击的事件
        //MloginButton.setOnClickListener(this) 方法1
        //匿名对象的方式
//        方法2 MloginButton.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                println("2按钮被点击了")
//            }
////        })

//    方法3    MloginButton.setOnClickListener({view : View? ->
//            println("3。按钮被点击了")
//     })
//  方法4      MloginButton.setOnClickListener{view : View? ->
//            println("4按钮被点击了")
//        }
        MloginButton.setOnClickListener{
            /*
            //添加旋转动画，动画结束之后在跳转到下一个界面 旋转 缩放 平移 透明度
           val img =  ObjectAnimator.ofFloat(img,"rotation",0f,360f)
            img.duration = 100
            img.repeatCount = 20
            img.start()

            //监听动画的结束事件
            img.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                    //界面跳转
                    startActivity(Intent(this@MainActivity,DetailActivity::class.java))
                }

                override fun onAnimationCancel(animation: Animator?) {

                }

                override fun onAnimationStart(animation: Animator?) {

                }

            })*/
            /*

            //常用kotlin函数 also apply run with
            1.also ObjectAnimator.ofFloat(img,"rotation",0f,360f).also {
                it.duration = 100
                it.repeatCount = 20
                it.start()
                it.addListener(object : Animator.AnimatorListener{
                    override fun onAnimationRepeat(animation: Animator?) {

                    }

                    override fun onAnimationEnd(animation: Animator?) {
                        //界面跳转
                        startActivity(Intent(this@MainActivity,DetailActivity::class.java))
                    }

                    override fun onAnimationCancel(animation: Animator?) {

                    }

                    override fun onAnimationStart(animation: Animator?) {

                    }

                })
        }
             */
            //apply 直接在对象内部使用代码块 可以访问这个对象本身的属性和方法 例如duration（时间）方法
            ObjectAnimator.ofFloat(img,"rotation",0f,360f).apply {
                duration = 100
                repeatCount = 6
                start()
                /*
                addListener(object : Animator.AnimatorListener{
                    override fun onAnimationRepeat(animation: Animator?) {

                    }

                    override fun onAnimationEnd(animation: Animator?) {
                       startActivity(Intent(this@MainActivity,DetailActivity::class.java))
                    }

                    override fun onAnimationCancel(animation: Animator?) {

                    }

                    override fun onAnimationStart(animation: Animator?) {

                    }

                })
                 */
                addListener(object :MyAnimatorListener(){
                    override fun onAnimationEnd(animation: Animator?) {
                        startActivity(Intent(this@MainActivity,DetailActivity::class.java))
                    }
                })

            }

        }
    }

    override fun onClick(v: View?) {
        println("按钮被点击了")
    }
}