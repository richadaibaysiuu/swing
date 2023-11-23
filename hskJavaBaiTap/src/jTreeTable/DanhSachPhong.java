package jTreeTable;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class DanhSachPhong extends JFrame
{
	private JTree tree;
	public DanhSachPhong()
	{
		setTitle("^-^");
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setSize(500, 300);
	    setLocationRelativeTo(null);
	    DefaultMutableTreeNode root=new DefaultMutableTreeNode("Danh sách phòng ban");
		
		DefaultMutableTreeNode ptc=new DefaultMutableTreeNode("Phòng tổ chức");
		root.add(ptc);
		DefaultMutableTreeNode pkt=new DefaultMutableTreeNode("Phòng kỹ thuật");
		root.add(pkt);
	//	ptc.add(new DefaultMutableTreeNode(ptochuc));
	//	pkt.add(new DefaultMutableTreeNode(pkythuat));
		//tạo cây và để trong scroll
		tree=new JTree(root);
		JScrollPane scrollTree=new JScrollPane(tree);
		getContentPane().add(scrollTree);
		 tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                        tree.getLastSelectedPathComponent();
                
                if (node == null) return;
                
              
                Object nodeInfo = node.getUserObject();
                
                if (node.isNodeDescendant(ptc)) 
                {
              
                    PhongToChuc frame=new PhongToChuc();
                    frame.setVisible(true);
               //     frame1.setVisible(true);
                } 
                if (node.isNodeDescendant(pkt)) {
                  
                          PhongKyThuat frame1=new PhongKyThuat();
                          frame1.setVisible(true);
                      } 
                
            }
        });
		
		
	}
	
}
