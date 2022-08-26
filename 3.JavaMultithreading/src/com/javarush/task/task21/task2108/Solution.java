package com.javarush.task.task21.task2108;

/* 
Клонирование растений
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);

        System.out.println(tree.equals(clone));
        System.out.println(Arrays.equals(tree.getBranches(), clone.getBranches()));
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        protected Tree clone() throws CloneNotSupportedException {
            String[] newBranches = new String[this.branches.length];
            for (int i = 0; i < branches.length; i++) {
                newBranches[i] = branches[i];
            }
            Tree result = new Tree(getName(), newBranches);
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tree)) return false;
            if (o == null) return false;
            Tree tree = (Tree) o;
            return Arrays.equals(branches, tree.branches);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(branches);
        }
    }
}
