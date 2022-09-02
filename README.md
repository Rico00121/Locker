# Locker

## 开发环境
 - JDK1.8+
 
## 业务需求

需求描述：储物柜(Locker)可以存包、取包
![locker](./locker.png)

评分标准：参考Classroom中的评分标准Excel文档

### 需求澄清总结：
1. 储物柜没有容量限制
2. 储物柜没有尺寸限制，默认多大的包都能存
3. 硬件系统功能不需要考虑（开门/关门/按钮/停电/没票纸）
4. 存包失败，需要提示用户是因为储物柜满了
5. 取包失败，需要提示用户是因为票据无效
6. 存包的位置是随机，没有顺序
7. 不要脑补需求，及时和PO确认
8. 不考虑并发

### tasking
1. 容量足够时，需要返回ticket
2. 没有足够容量时，提示储物柜已满
3. 给一张合理的票，取出包 可用容量+1
4. 给一张不合理的票，提示无效票据
5. 给一张已经用过的票，提示无效票据


### 需求澄清总结2：
需求：作为一个初级储物柜机器人，我能够按储物柜的顺序来存包，也能取包
需求澄清：
1. PrimaryLockerRobot存包是按照locker顺序存包
2. PrimaryLockerRobot在某个Locker内存包的位置是随机的
3. 报错信息和Locker是一致的
4. PrimaryLockerRobot至少管理一个Locker
5. PrimaryLockerRobot会回收取过包的票据
   Note：
   在Locker的基础上继续完善，不需要重新创建仓库

### tasking
1. 管理两个Locker，当两个都有容量，存入第一个 反票
2. 管理两个Locker，当第一个满，存入第二个 反票
3. 管理两个Locker，当两个都没有容量，存包 失败 给提示
4. 管理两个Locker，当拿一个有效的票，取包成功
5. 管理两个Locker，当拿一个假的票，取保失败 提示非法票据


### 需求澄清总结3：
需求：作为一个聪明的储物柜机器人，我能够将包存在可用容量最多的储物柜，并可以取出
需求澄清：
1. PrimaryLockerRobot存包是按照locker顺序存包
2. PrimaryLockerRobot在某个Locker内存包的位置是随机的
3. 报错信息和Locker是一致的
4. PrimaryLockerRobot至少管理一个Locker
5. PrimaryLockerRobot会回收取过包的票据
6. SmartLockerRobot可以在可用容量最多的储物柜中存包
   Note：
   在Locker的基础上继续完善，不需要重新创建仓库

### tasking
1. SmartLockerRobot管理两个Locker，当两个都有容量第一个可用3 第二个可用2，存入第一个 反票
2. SmartLockerRobot管理两个Locker，当两个都有容量第一个可用2 第二个可用3，存入第二个 反票
3. SmartLockerRobot管理两个Locker，当两个可用都为2，存入第一个 反票
4. SmartLockerRobot管理两个Locker，可用都为0，存包失败 提示满
5. SmartLockerRobot管理两个Locker，存包 反票，成功取出包
6. SmartLockerRobot管理两个Locker，存包 使用一张假票取，提示不合理票据
7. SmartLockerRobot和PrimaryLockerRobot共同管理两个柜子， SmartLockerRobot拿到一张由PrimaryLockerRobot存包返回的票，拿到包
8. SmartLockerRobot和PrimaryLockerRobot共同管理两个柜子， PrimaryLockerRobot拿到一张由SmartLockerRobot存包返回的票，拿到包

### 需求澄清总结4：
需求：作为储物柜机器人的经理，我要管理多个机器人，我可以让机器人存包，也可以自己存包
需求澄清：
1. LockerRobotManager至少管理一个Robot或者Locker
2. LockerRobotManager会让Robot先存包，然后再自己存包
3. LockerRobotManager管理的Robot/Locker按顺序存包

### tasking
1. 管理2个Locker，且均有空间，0个Robot，当manager存包，成功存入第一个locker，返回票据
2. 管理2个Locker，0个Robot，Locker1满，当manager存包，存入第二个柜子，反票
3. 管理2个Locker，0个Robot，Locker均满，当manager存包，提示存包失败
4. 管理0个Locker，2个Robot，且2个robot管理的locker均有空间，让manager存包，成功由第一个robot存入，返回票
5. 管理0个Locker，2个Robot，且第一个robot管理的locker已满，第二个robot有空，manager存包，成功由第二个存入，返回票据
6. 管理0个Locker，2个Robot，且2个robot管理的locker均已满，manager存包，存包失败，提示储物柜已满
7. 管理1个Locker，1个Robot，均有空间，让manager存包，成功由robot存入，返回票
8. 管理1个Locker，1个Robot，locker有空间，让manager存包，成功存入locker，返回票
9. 管理1个Locker，1个Robot，均满，让manager存包，成功由robot存入，存包失败，提示储物柜已满
10. 管理2个locker，0个robot，且票有效，当manager取包，取包成功
11. 管理2个locker，0个robot，且票无效，当manager取包，取包失败
12. 管理0个locker，2个robot，且票有效，当manager取包，取包成功
13. 管理0个locker，2个robot，且票无效，当manager取包，取包失败，提示无效票据
14. 管理1个locker，1个robot，且票有效，当manager取包，取包成功
15. 管理1个locker，1个robot，且票无效，当manager取包，取包失败，提示无效票据