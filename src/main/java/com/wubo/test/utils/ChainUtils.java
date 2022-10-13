package com.wubo.test.utils;

import io.vavr.control.Try;

public class ChainUtils {
    public static abstract class AbstractStep{
        private AbstractStep next;
        protected abstract int getOrder();

        protected abstract Try<String> step(String str);

        public void setNext(AbstractStep next){
            this.next = next;
        }

        public Try<String> doStep(String str){
            if(next == null){
                return step(str);
            }
            else {
                return step(str).flatMap(next::doStep);
            }
        }

        // 使用构造者模式创建
        public static class Builder {
            // 分别记录第一个处理者和下一个处理者，类似于链表结构
            private AbstractStep head;
            private AbstractStep tail;

            // 添加处理者
            public Builder addChecker(AbstractStep chain) {
                System.out.println("+++++++++++++++++++++++");
                if (this.head == null) {
                    this.head = this.tail = chain;
                    return this;
                }

                if(chain.getOrder() <= head.getOrder()){
                    chain.next = this.head;
                    this.head = chain;
                    System.out.println("add head " + chain.getOrder());
                    return this;
                }

                // 设置下一个处理者
                //通过辅助节点遍历来找到添加的位置
                AbstractStep temp = head;
                while (true) {
                    AbstractStep tempNext = temp.next;
                    System.out.println("======================");
                    //temp 为最后一个节点
                    if(tempNext == null){
                        temp.next = chain;
                        this.tail = chain;
                        System.out.println("add last " + chain.getOrder());
                        break;
                    }
                    if(tempNext.getOrder() >= chain.getOrder()){
                        temp.next = chain ;
                        chain.next = tempNext;
                        System.out.println("add middle " + chain.getOrder());
                        break;
                    }
                    temp = temp.next;
                    System.out.println("continue next-" + temp.getOrder());
                }
                return this;
            }

            public AbstractStep build() {


                return this.head;
            }
        }

    }

    public static class StepOne extends AbstractStep{
        private int order = 1;

        public StepOne(int order){
            this.order = order;
        }

        @Override
        protected int getOrder() {
            return order;
        }

        @Override
        protected Try<String> step(String str) {
            System.err.println("order:" + order);
            return Try.success(str);
        }
    }

    public static void main(String[] args) {
        AbstractStep build = new AbstractStep.Builder().addChecker(new StepOne(19))
                .addChecker(new StepOne(1))
                .addChecker(new StepOne(90))
                .addChecker(new StepOne(14))
                .addChecker(new StepOne(18))
                .addChecker(new StepOne(100))
                .addChecker(new StepOne(1))
                .addChecker(new StepOne(101))
                .addChecker(new StepOne(15))
                .build();
        build.doStep("1231");
    }
}
