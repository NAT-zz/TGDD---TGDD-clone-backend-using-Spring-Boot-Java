package hcmute.edu.tgdd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.edu.tgdd.model.Kind;
import hcmute.edu.tgdd.repository.KindRepository;

@Service
public class KindService {
	@Autowired
	private KindRepository kindRepository;

	public KindService() {
		super();
	}

	public KindService(KindRepository kindRepository) {
		super();
		this.kindRepository = kindRepository;
	}
	public Kind insertKind(Kind newKind) throws Exception{
		try
		{
			List<Kind> foundKind = kindRepository.findByNameIgnoreCase(newKind.getName());
			if(foundKind.isEmpty())
				return updateOrinsert(newKind);
			else 
				throw new Exception();
		}
		catch (Exception e) {
			throw e;
		}
	}
	public List<Kind> getAllKind(){
		return kindRepository.findAll();
	}
	public Optional<Kind> findKindById(int id){
		return kindRepository.findById(id);
	}
	public Kind updateOrinsert(Kind kind) {
		return kindRepository.save(kind);
	}
	public void deleteKindById(int id) throws Exception{
		kindRepository.deleteById(id);
	}
	public boolean kindExistedById(int id) {
		return kindRepository.existsById(id);
	}
//	public Kind updateKindById(Kind newKind, int id) throws Exception{
//		Kind updateKind = findKindById(id)
//				.map(kind -> {
//					kind.setName(newKind.getName());
//					return updateOrinsert(kind);
//				}).orElseThrow();
//		return updateKind;
//	}
}
