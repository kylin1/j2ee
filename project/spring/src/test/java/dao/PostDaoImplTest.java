package dao;

import junit.framework.TestCase;
import web.dao.impl.PostDaoImpl;
import web.model.communication.Post;

/**
 * Created by JiachenWang on 2016/8/30.
 */
public class PostDaoImplTest extends TestCase {

    public void testGetAllPost() throws Exception {
        PostDaoImpl test = new PostDaoImpl();
        System.out.println(test.getAllPost().size());
    }

    public void testSearch() throws Exception {
        PostDaoImpl test = new PostDaoImpl();
        System.out.println(test.search("title").size());
    }

    public void testGetNewPostID() throws Exception {
        PostDaoImpl test = new PostDaoImpl();
        System.out.println(test.getNewPostID());
    }

    public void testGetNewCommentID() throws Exception {
        PostDaoImpl test = new PostDaoImpl();
        System.out.println(test.getNewCommentID("0000001"));
    }

    public void testGetPost() throws Exception {
        PostDaoImpl test = new PostDaoImpl();
        Post info = test.getPost("0000001");
        System.out.println(info.toString());
    }

    public void testResetViews() throws Exception {
        PostDaoImpl test = new PostDaoImpl();
        Post info = test.getPost("0000001");
        info.getViews().setLikes(6000);
        test.resetViews(info.getViews());
    }

    public void testDeleteComment() throws Exception {
        PostDaoImpl test = new PostDaoImpl();
        test.deleteComment("321", 321);
    }

    public void testDelete() throws Exception {
        PostDaoImpl test = new PostDaoImpl();
        test.delete("0000002");
    }

    public void testSave() throws Exception {

    }

//    public void testGetBasicInfoByID() throws Exception {
//        PostDaoImpl test = new PostDaoImpl();
//        PostBasicInfo info = test.getBasicInfoByID("1");
//        System.out.println(info.toString());
//    }
//
//    public void testGetPostCommentByID() throws Exception {
//        PostDaoImpl test = new PostDaoImpl();
//        List<PostComment> info = test.getPostCommentByID("0000001");
//        System.out.println(info.size());
//        System.out.println(info.get(0).toString());
//    }
//
//    public void testGetPostViewsByID() throws Exception {
//        PostDaoImpl test = new PostDaoImpl();
//        PostViews info = test.getPostViewsByID("0000001");
//        System.out.println(info.toString());
//    }

}