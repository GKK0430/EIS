package tw.eis.bullboard.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class BulletinBoardDAO implements IBulletinBoardDAO {

	private SessionFactory SessionFactory;

	@Autowired
	public BulletinBoardDAO(@Qualifier("sessionFactory") SessionFactory SessionFactory) {
		this.SessionFactory=SessionFactory;
	}
	
	
	
	@Override
	public boolean insertBulletin(BulletinBoard BulletinBoard) {
		Session Session = SessionFactory.getCurrentSession();
		Session.save(BulletinBoard);
		return false;
	}

	@Override
	public boolean updateBulletin(BulletinBoard BulletinBoard) {
		return false;
	}

	@Override
	public List<BulletinBoard> queryBulletinRecord(int EmployeeID) {

		Session Session = SessionFactory.getCurrentSession();
		Query query = Session.createQuery("from BulletinBoard where EmployeeID = :EmployeeID and (GETDATE()-downTime)>=0",BulletinBoard.class);
		query.setInteger("EmployeeID", EmployeeID);
		List<BulletinBoard> BulletinBoards = query.list();
		return BulletinBoards;
	}

	@Override
	public List<BulletinBoard> queryBulletinForLook(String department) {
		Session Session = SessionFactory.getCurrentSession();
		Query query = Session.createQuery("from BulletinBoard where Authority like :department and ((GETDATE()-upTime)>=0 and (GETDATE()-downTime)<=0)",BulletinBoard.class);
		query.setString("department", "%"+department+"%");
		List<BulletinBoard> BulletinBoards = query.list();
			
		return BulletinBoards;

	}

	@Override
	public List<BulletinBoard> queryBulletinByOwnCreate(int EmployeeID) {
		Session Session = SessionFactory.getCurrentSession();
		Query query = Session.createQuery("from BulletinBoard where EmployeeID = :EmployeeID and ((GETDATE()-upTime)>=0 and (GETDATE()-downTime)<=0)",BulletinBoard.class);
		query.setInteger("EmployeeID", EmployeeID);
		List<BulletinBoard> BulletinBoards = query.list();
		return BulletinBoards;
	}

}
