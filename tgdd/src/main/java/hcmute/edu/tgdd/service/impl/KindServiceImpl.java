package hcmute.edu.tgdd.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.edu.tgdd.model.Kind;
import hcmute.edu.tgdd.repository.KindRepository;
import hcmute.edu.tgdd.service.KindService;

@Service
public class KindServiceImpl implements KindService{
	@Autowired
	private KindRepository kindRepository;

	public Kind insertKind(Kind newKind) {
		return updateOrInsert(newKind);
	}
	public List<Kind> getAllKind(){
		return kindRepository.findAll();
	}
	public Optional<Kind> findKindById(int id){
		return kindRepository.findById(id);
	}
	public Kind updateOrInsert(Kind kind) {
		return kindRepository.save(kind);
	}
	public void deleteKindById(int id) {
		kindRepository.deleteById(id);
	}
	public boolean kindExistedById(int id) {
		return kindRepository.existsById(id);
	}
	public Kind updateKindById(Kind newKind, int id) {
		Kind updateKind = findKindById(id)
				.map(kind -> {
					kind.setName(newKind.getName());
					
					return updateOrInsert(kind);
				}).orElseThrow();
		return updateKind;
	}
}
