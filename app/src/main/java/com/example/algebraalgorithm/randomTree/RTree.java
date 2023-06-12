package com.example.algebraalgorithm.randomTree;

import java.util.Random;

public class RTree {

    public RNode find(RNode p, int k) // поиск ключа k в дереве p
    {
        if( p == null ) return null; // в пустом дереве можно не искать
        if( k == p.key)
            return p;
        if( k < p.key)
            return find(p.left, k);
        else
            return find(p.right,k);
    }

    public int getsize(RNode p) // обертка для поля size, работает с пустыми деревьями (t=NULL)
    {
        if( p == null) return 0;
        return p.size;
    }

    public void fixsize(RNode p) // установление корректного размера дерева
    {
        p.size = getsize(p.left)+getsize(p.right)+1;
    }

    public RNode rotateright(RNode p) // правый поворот вокруг узла p
    {
        RNode q = p.left;
        if (q == null ) return p;
        p.left = q.right;
        q.right = p;
        q.size = p.size;
        fixsize(p);
        return q;
    }

    public RNode rotateleft(RNode q) // левый поворот вокруг узла q
    {
        RNode p = q.right;
        if( p == null ) return q;
        q.right = p.left;
        p.left = q;
        p.size = q.size;
        fixsize(q);
        return p;
    }

    public RNode insertroot(RNode p, int k) // вставка нового узла с ключом k в корень дерева p
    {
        if( p == null ) return new RNode(k);
        if( k< p.key )
        {
            p.left = insertroot(p.left, k);
            return rotateright(p);
        }
        else
        {
            p.right = insertroot(p.right, k);
            return rotateleft(p);
        }
    }

    public RNode insert(RNode p, int k) // рандомизированная вставка нового узла с ключом k в дерево p
    {
        if( p == null  ) return new RNode(k);
        final Random random = new Random();
        if(random.nextInt(p.size+1) % (p.size+1)== 0)
            return insertroot(p,k);
        if( p.key > k )
            p.left = insert(p.left,k);
        else
            p.right = insert(p.right,k);
        fixsize(p);
        return p;
    }

    public RNode join(RNode p, RNode q) // объединение двух деревьев
    {
        if( p == null ) return q;
        if( q == null ) return p;
        final Random random = new Random();
        if(random.nextInt(p.size+q.size) % (p.size+q.size) < p.size )
        {
            p.right = join(p.right, q);
            fixsize(p);
            return p;
        }
        else
        {
            q.left = join(p, q.left);
            fixsize(q);
            return q;
        }
    }

    public RNode remove(RNode p, int k) // удаление из дерева p первого найденного узла с ключом k
    {
        if( p == null ) return p;
        if( p.key==k )
        {
            RNode q = join(p.left, p.right);
            p = null;
            return q;
        }
        else if( k < p.key )
            p.left = remove(p.left, k);
        else
            p.right = remove(p.right, k);
        return p;
    }
}
